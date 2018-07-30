package com.zlsoft.award.repository;

import com.zlsoft.award.domain.Award;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AwardRepository extends JpaRepository<Award, Long>,
        JpaSpecificationExecutor<Award>,
        BaseRepository<Award, Long> {
}
