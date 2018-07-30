package com.zlsoft.award.repository;

import com.zlsoft.award.domain.Reference;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReferenceRepository extends JpaRepository<Reference, Long>,
        JpaSpecificationExecutor<Reference>,
        BaseRepository<Reference, Long> {
}
