package com.zlsoft.common.repository;

import com.zlsoft.domain.Dictionary;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long>,
        JpaSpecificationExecutor<Dictionary>,
        BaseRepository<Dictionary, Long> {
}
