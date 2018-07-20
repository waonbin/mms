package com.zlsoft.common.repository;

import com.zlsoft.domain.FileMetadata;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long>,
        JpaSpecificationExecutor<FileMetadata>,
        BaseRepository<FileMetadata, Long> {
}
