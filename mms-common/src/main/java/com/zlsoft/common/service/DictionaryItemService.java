package com.zlsoft.common.service;

import com.zlsoft.domain.DictionaryItem;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface DictionaryItemService extends SimpleService<DictionaryItem, Long> {

    List<DictionaryItem> findByDictionaryId(long dictionaryId);
}
