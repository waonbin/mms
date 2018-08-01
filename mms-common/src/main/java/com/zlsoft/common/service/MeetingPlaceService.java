package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface MeetingPlaceService extends SimpleService<MeetingPlace, Long> {

    List<MeetingPlace> findByMeetingId(Long meetingId);
    void deleteByMeetingId(Long meetingId);

}
