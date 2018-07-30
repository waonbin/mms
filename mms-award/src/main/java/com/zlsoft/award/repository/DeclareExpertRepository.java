package com.zlsoft.award.repository;

import com.zlsoft.award.domain.DeclareExpert;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeclareExpertRepository extends JpaRepository<DeclareExpert, Long>,
        JpaSpecificationExecutor<DeclareExpert>,
        BaseRepository<DeclareExpert, Long> {
}
