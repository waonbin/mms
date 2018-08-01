package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingPlaceRepository;
import com.zlsoft.common.service.MeetingPlaceService;
import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("meetingPlaceService")
public class MeetingPlaceServiceImpl extends BaseSimpleService<MeetingPlace, Long> implements MeetingPlaceService {

    @Override
    public List<MeetingPlace> findByMeetingId(Long meetingId) {
        return ((MeetingPlaceRepository)this.getRepository()).findByMeetingId(meetingId);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingPlaceRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
