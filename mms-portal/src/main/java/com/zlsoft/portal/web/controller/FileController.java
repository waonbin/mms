package com.zlsoft.portal.web.controller;

import com.google.common.base.Strings;
import com.zlsoft.common.service.FileMetadataService;
import com.zlsoft.domain.FileMetadata;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Inject
    private FileMetadataService fileMetadataService;

    @Value("${mms.store_home}")
    private String storeHome;

    /**
     * POST  /upload : upload single file
     * @param file uploaded file
     * @return HTTP Status to figure if upload is successful
     */
    @PostMapping("/upload")
    public @ResponseBody ResponseEntity upload(@RequestParam("file") MultipartFile file) {

        //check if file is null
        if(file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        //original file name is saved to db
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();

        //get file suffix
        String suffix = originalFilename.lastIndexOf(".") == -1 ? ""
                : originalFilename.substring(originalFilename.lastIndexOf("."));

        //create new file name with timestamp
        String storeFileName = String.valueOf(System.currentTimeMillis())
                + (Strings.isNullOrEmpty(suffix) ? suffix : "");

        //relative path is used to save db
        String relativePath = Paths.get(getStorePath(), storeFileName).toString();

        //absolute path is used to save file
        Path absolutePath = Paths.get(storeHome, relativePath);

        //get dest file
        File dest = new File(absolutePath.toUri());

        //check if folder exist
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        try {

            //calculate md5 code
            String md5 = md5Hex(file.getInputStream());

            //save file
            file.transferTo(dest);

            //create file metadata
            FileMetadata fileMetadata = new FileMetadata();
            fileMetadata.setFileName(originalFilename);
            fileMetadata.setSuffix(suffix);
            fileMetadata.setFilePath(relativePath);
            fileMetadata.setFileSize(size);
            fileMetadata.setMd5Code(md5);

            //save file metadata into db
            this.fileMetadataService.save(fileMetadata);
        } catch (IOException e) {
            logger.error("FILE UPLOAD FAILED.", e);
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    /**
     * POST  /upload/multiple : upload multiple files
     * @param files uploaded files
     * @return HTTP Status to figure if upload is successful
     */
    @PostMapping("/upload/multiple")
    public @ResponseBody ResponseEntity upload(@RequestParam("files") List<MultipartFile> files) {

        //check if file is null
        if (files == null || files.size() == 0) {
            return ResponseEntity.badRequest().build();
        }

        List<FileMetadata> fileMetadatas = new ArrayList<>();

        for (MultipartFile file: files) {

            //check if file is null
            if(file == null || file.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            //original file name is saved to db
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();

            //get file suffix
            String suffix = originalFilename.lastIndexOf(".") == -1 ? ""
                    : originalFilename.substring(originalFilename.lastIndexOf("."));

            //create new file name with timestamp
            String storeFileName = String.valueOf(System.currentTimeMillis())
                    + (Strings.isNullOrEmpty(suffix) ? suffix : "");

            //relative path is used to save db
            String relativePath = Paths.get(getStorePath(), storeFileName).toString();

            //absolute path is used to save file
            Path absolutePath = Paths.get(storeHome, relativePath);

            //get dest file
            File dest = new File(absolutePath.toUri());

            //check if folder exist
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }

            try {
                //save file
                file.transferTo(dest);

                //create file metadata
                FileMetadata fileMetadata = new FileMetadata();
                fileMetadata.setFileName(originalFilename);
                fileMetadata.setSuffix(suffix);
                fileMetadata.setFilePath(relativePath);
                fileMetadata.setFileSize(size);
                fileMetadata.setMd5Code(md5Hex(file.getInputStream()));

                fileMetadatas.add(fileMetadata);
            } catch (IOException e) {
                logger.error("FILE UPLOAD FAILED.", e);
                return ResponseEntity.badRequest().build();
            }
        }

        //save file metadata into db
        this.fileMetadataService.saveAll(fileMetadatas);

        return ResponseEntity.ok().build();
    }

    /**
     * get file relative store path
     * @return file relative store path
     */
    private String getStorePath() {
        Calendar calendar = Calendar.getInstance();
        return Paths.get(String.valueOf(calendar.get(Calendar.YEAR)),
                String.valueOf(calendar.get(Calendar.MONTH)),
                String.valueOf(calendar.get(Calendar.DATE))).toString();
    }

    /**
     * get md5 code of file stream
     * @param stream file steam
     * @return md5 code
     * @throws IOException On error reading from the stream
     */
    private String md5Hex(InputStream stream) throws IOException {
        return DigestUtils.md5Hex(stream);
    }
}
