package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeetingDuesService extends SimpleService<MeetingDues, Long> {

    Page<MeetingDues> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
