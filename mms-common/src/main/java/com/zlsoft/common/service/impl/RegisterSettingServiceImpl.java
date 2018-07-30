package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.RegisterSettingService;
import com.zlsoft.domain.RegisterSetting;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("registerSettingService")
public class RegisterSettingServiceImpl extends BaseSimpleService<RegisterSetting, Long> implements RegisterSettingService {
}
