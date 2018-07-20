package com.zlsoft.common.repository;

import com.zlsoft.domain.DictionaryItem;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DictionaryItemRepository extends JpaRepository<DictionaryItem, Long>,
        JpaSpecificationExecutor<DictionaryItem>,
        BaseRepository<DictionaryItem, Long> {

    List<DictionaryItem> findByDictionaryId(long dictionaryId);
}
