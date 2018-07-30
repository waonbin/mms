package com.zlsoft.award.repository;

import com.zlsoft.award.domain.DeclareFile;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeclareFileRepository extends JpaRepository<DeclareFile, Long>,
        JpaSpecificationExecutor<DeclareFile>,
        BaseRepository<DeclareFile, Long> {
}
