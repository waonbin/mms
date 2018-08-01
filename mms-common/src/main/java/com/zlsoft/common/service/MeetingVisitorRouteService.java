package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface MeetingVisitorRouteService extends SimpleService<MeetingVisitorRoute, Long> {

    List<MeetingVisitorRoute> findByMeetingId(Long meetingId);
    void deleteByMeetingId(Long meetingId);

}
