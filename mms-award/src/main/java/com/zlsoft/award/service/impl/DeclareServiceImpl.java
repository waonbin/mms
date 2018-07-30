package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.Declare;
import com.zlsoft.award.service.DeclareService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("declareService")
public class DeclareServiceImpl extends BaseSimpleService<Declare, Long> implements DeclareService {
}
