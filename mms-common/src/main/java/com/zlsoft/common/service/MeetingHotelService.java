package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingHotel;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface MeetingHotelService extends SimpleService<MeetingHotel, Long> {

    List<MeetingHotel> findByMeetingId(Long meetingId);
    void deleteByMeetingId(Long meetingId);

}
