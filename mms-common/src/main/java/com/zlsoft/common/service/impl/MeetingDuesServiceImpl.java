package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingDuesRepository;
import com.zlsoft.common.service.MeetingDuesService;
import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("meetingDuesService")
public class MeetingDuesServiceImpl extends BaseSimpleService<MeetingDues, Long> implements MeetingDuesService {

    @Override
    public List<MeetingDues> findByMeetingId(Long meetingId) {
        return ((MeetingDuesRepository)this.getRepository()).findByMeetingId(meetingId);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingDuesRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
