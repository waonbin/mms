package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.DeclareHistory;
import com.zlsoft.award.service.DeclareHistoryService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("declareHistoryService")
public class DeclareHistoryServcieImpl extends BaseSimpleService<DeclareHistory, Long> implements DeclareHistoryService {
}
