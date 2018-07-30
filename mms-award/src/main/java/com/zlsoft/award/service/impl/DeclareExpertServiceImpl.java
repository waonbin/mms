package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.DeclareExpert;
import com.zlsoft.award.service.DeclareExpertService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("declareExpertService")
public class DeclareExpertServiceImpl extends BaseSimpleService<DeclareExpert, Long> implements DeclareExpertService {
}
