package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingAffair;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface MeetingAffairService extends SimpleService<MeetingAffair, Long> {

    List<MeetingAffair> findByMeetingId(Long meetingId);
    void deleteByMeetingId(Long meetingId);

}
