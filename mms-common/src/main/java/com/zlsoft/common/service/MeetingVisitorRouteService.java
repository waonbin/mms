package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.service.SimpleService;

public interface MeetingVisitorRouteService extends SimpleService<MeetingVisitorRoute, Long> {
    void deleteByMeetingId(Long meetingId);
}
