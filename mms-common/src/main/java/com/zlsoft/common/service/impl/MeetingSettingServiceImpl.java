package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingSettingService;
import com.zlsoft.domain.MeetingSetting;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingSettingService")
public class MeetingSettingServiceImpl extends BaseSimpleService<MeetingSetting, Long> implements MeetingSettingService {
}
