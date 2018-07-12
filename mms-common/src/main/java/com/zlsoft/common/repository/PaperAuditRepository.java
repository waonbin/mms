package com.zlsoft.common.repository;

import com.zlsoft.domain.PaperAudit;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperAuditRepository extends JpaRepository<PaperAudit, Long>, BaseRepository<PaperAudit, Long> {
}
