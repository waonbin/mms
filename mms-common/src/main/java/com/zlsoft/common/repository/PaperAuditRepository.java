package com.zlsoft.common.repository;

import com.zlsoft.domain.PaperAudit;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaperAuditRepository extends JpaRepository<PaperAudit, Long>,
        JpaSpecificationExecutor<PaperAudit>,
        BaseRepository<PaperAudit, Long> {
}
