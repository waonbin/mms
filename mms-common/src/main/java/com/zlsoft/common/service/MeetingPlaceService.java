package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.service.SimpleService;

public interface MeetingPlaceService extends SimpleService<MeetingPlace, Long> {
    void deleteByMeetingId(Long meetingId);
}
