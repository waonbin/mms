package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.AwardQuota;
import com.zlsoft.award.service.AwardQuotaService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("awardQuotaService")
public class AwardQuotaServiceImpl extends BaseSimpleService<AwardQuota, Long> implements AwardQuotaService {
}
