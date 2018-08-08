package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingVisitorRouteRepository;
import com.zlsoft.common.service.MeetingVisitorRouteService;
import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("meetingVisitorRouteService")
public class MeetingVisitorRouteServiceImpl extends BaseSimpleService<MeetingVisitorRoute, Long> implements MeetingVisitorRouteService {

    @Override
    public Page<MeetingVisitorRoute> findByMeetingId(Long meetingId, Pageable pageable) {
        return ((MeetingVisitorRouteRepository)this.getRepository()).findByMeetingId(meetingId, pageable);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingVisitorRouteRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
