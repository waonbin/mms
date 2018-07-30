package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.Expert;
import com.zlsoft.award.service.ExpertService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("expertService")
public class ExpertServiceImpl extends BaseSimpleService<Expert, Long> implements ExpertService {
}
