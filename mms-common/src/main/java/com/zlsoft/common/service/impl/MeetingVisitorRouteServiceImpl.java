package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingVisitorRouteRepository;
import com.zlsoft.common.service.MeetingVisitorRouteService;
import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingVisitorRouteService")
public class MeetingVisitorRouteServiceImpl extends BaseSimpleService<MeetingVisitorRoute, Long> implements MeetingVisitorRouteService {
    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingVisitorRouteRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
