package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingVisitorRouteRepository;
import com.zlsoft.common.service.MeetingVisitorRouteService;
import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("meetingVisitorRouteService")
public class MeetingVisitorRouteServiceImpl extends BaseSimpleService<MeetingVisitorRoute, Long> implements MeetingVisitorRouteService {

    @Override
    public List<MeetingVisitorRoute> findByMeetingId(Long meetingId) {
        return ((MeetingVisitorRouteRepository)this.getRepository()).findByMeetingId(meetingId);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingVisitorRouteRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
