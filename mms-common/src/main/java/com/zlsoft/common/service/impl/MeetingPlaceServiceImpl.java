package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingPlaceRepository;
import com.zlsoft.common.service.MeetingPlaceService;
import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("meetingPlaceService")
public class MeetingPlaceServiceImpl extends BaseSimpleService<MeetingPlace, Long> implements MeetingPlaceService {

    @Override
    public Page<MeetingPlace> findByMeetingId(Long meetingId, Pageable pageable) {
        return ((MeetingPlaceRepository)this.getRepository()).findByMeetingId(meetingId, pageable);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingPlaceRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
