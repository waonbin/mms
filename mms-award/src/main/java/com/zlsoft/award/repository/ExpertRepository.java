package com.zlsoft.award.repository;

import com.zlsoft.award.domain.Expert;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExpertRepository extends JpaRepository<Expert, Long>,
        JpaSpecificationExecutor<Expert>,
        BaseRepository<Expert, Long> {
}
