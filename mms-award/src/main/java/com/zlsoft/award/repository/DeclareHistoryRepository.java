package com.zlsoft.award.repository;

import com.zlsoft.award.domain.DeclareHistory;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeclareHistoryRepository extends JpaRepository<DeclareHistory, Long>,
        JpaSpecificationExecutor<DeclareHistory>,
        BaseRepository<DeclareHistory, Long> {
}
