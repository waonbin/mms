package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingAffair;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MeetingAffairService extends SimpleService<MeetingAffair, Long> {

    Page<MeetingAffair> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
