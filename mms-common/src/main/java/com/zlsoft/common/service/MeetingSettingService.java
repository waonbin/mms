package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingSetting;
import com.zlsoft.utils.service.SimpleService;

public interface MeetingSettingService extends SimpleService<MeetingSetting, Long> {

    void deleteByMeetingId(Long meetingId);
}
