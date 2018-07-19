package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.DictionaryItemRepository;
import com.zlsoft.common.service.DictionaryItemService;
import com.zlsoft.domain.DictionaryItem;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("dictionaryItemService")
public class DictionaryItemServiceImpl extends BaseSimpleService<DictionaryItem, Long> implements DictionaryItemService {

    @Override
    public List<DictionaryItem> findByDictionaryId(long dictionaryId) {
        return ((DictionaryItemRepository)this.getRepository()).findByDictionaryId(dictionaryId);
    }
}
