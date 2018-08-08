package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeetingPlaceService extends SimpleService<MeetingPlace, Long> {

    Page<MeetingPlace> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
