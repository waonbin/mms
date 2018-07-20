package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.FileMetadataService;
import com.zlsoft.domain.FileMetadata;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("fileMetadataService")
public class FileMetadataServiceImpl extends BaseSimpleService<FileMetadata, Long> implements FileMetadataService {
}
