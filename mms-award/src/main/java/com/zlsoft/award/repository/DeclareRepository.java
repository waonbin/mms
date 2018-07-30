package com.zlsoft.award.repository;

import com.zlsoft.award.domain.Declare;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeclareRepository extends JpaRepository<Declare, Long>,
        JpaSpecificationExecutor<Declare>,
        BaseRepository<Declare, Long> {
}
