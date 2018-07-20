package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "d_file_metadata")
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="file_id_generator")
    @TableGenerator(name = "file_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="file_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 文件名称
     */
    @Column(length = 64)
    private String fileName;

    /**
     * 文件扩展名
     */
    @Column(length = 16)
    private String suffix;

    /**
     * 文件路径（相对于存储根目录）
     */
    @Column(length = 1024)
    private String filePath;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * md5校验码
     */
    @Column(length = 32)
    private String md5Code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }
}
