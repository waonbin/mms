package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingHotel;
import com.zlsoft.utils.service.SimpleService;

public interface MeetingHotelService extends SimpleService<MeetingHotel, Long> {
    void deleteByMeetingId(Long meetingId);
}
