package com.zlsoft.common.repository;

import com.zlsoft.domain.DictionaryItem;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryItemRepository extends JpaRepository<DictionaryItem, Long>, BaseRepository<DictionaryItem, Long> {

    List<DictionaryItem> findByDictionaryId(long dictionaryId);
}
