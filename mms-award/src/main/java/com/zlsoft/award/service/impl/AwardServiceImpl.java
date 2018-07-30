package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.Award;
import com.zlsoft.award.service.AwardService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("awardService")
public class AwardServiceImpl extends BaseSimpleService<Award, Long> implements AwardService {
}
