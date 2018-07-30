package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.service.SimpleService;

public interface MeetingDuesService extends SimpleService<MeetingDues, Long> {
    void deleteByMeetingId(Long meetingId);
}
