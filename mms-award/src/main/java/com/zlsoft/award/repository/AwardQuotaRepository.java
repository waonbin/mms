package com.zlsoft.award.repository;

import com.zlsoft.award.domain.AwardQuota;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AwardQuotaRepository extends JpaRepository<AwardQuota, Long>,
        JpaSpecificationExecutor<AwardQuota>,
        BaseRepository<AwardQuota, Long> {
}
