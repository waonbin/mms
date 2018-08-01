package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface MeetingDuesService extends SimpleService<MeetingDues, Long> {

    List<MeetingDues> findByMeetingId(Long meetingId);
    void deleteByMeetingId(Long meetingId);

}
