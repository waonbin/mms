package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.DictionaryService;
import com.zlsoft.domain.Dictionary;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseSimpleService<Dictionary, Long> implements DictionaryService {
}
