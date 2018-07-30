package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingRegisterSettingService;
import com.zlsoft.domain.MeetingRegisterSetting;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingRegisterSettingService")
public class MeetingRegisterSettingServiceImpl extends BaseSimpleService<MeetingRegisterSetting, Long> implements MeetingRegisterSettingService {
}
