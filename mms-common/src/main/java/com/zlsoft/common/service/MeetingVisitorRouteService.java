package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeetingVisitorRouteService extends SimpleService<MeetingVisitorRoute, Long> {

    Page<MeetingVisitorRoute> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
