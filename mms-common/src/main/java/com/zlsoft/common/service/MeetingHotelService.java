package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingHotel;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeetingHotelService extends SimpleService<MeetingHotel, Long> {

    Page<MeetingHotel> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
