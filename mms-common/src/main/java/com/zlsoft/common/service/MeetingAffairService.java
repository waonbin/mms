package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingAffair;
import com.zlsoft.utils.service.SimpleService;

public interface MeetingAffairService extends SimpleService<MeetingAffair, Long> {
    void deleteByMeetingId(Long meetingId);
}
