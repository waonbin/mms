package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.Reference;
import com.zlsoft.award.service.ReferenceService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("referenceService")
public class ReferenceServiceImpl extends BaseSimpleService<Reference, Long> implements ReferenceService {
}
