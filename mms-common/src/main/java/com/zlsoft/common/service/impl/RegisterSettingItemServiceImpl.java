package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.RegisterSettingItemService;
import com.zlsoft.domain.RegisterSettingItem;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("registerSettingItemService")
public class RegisterSettingItemServiceImpl extends BaseSimpleService<RegisterSettingItem, Long> implements RegisterSettingItemService {
}
