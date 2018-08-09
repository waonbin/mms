package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingDuesRepository;
import com.zlsoft.common.service.MeetingDuesService;
import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingDuesService")
public class MeetingDuesServiceImpl extends BaseSimpleService<MeetingDues, Long> implements MeetingDuesService {

    @Override
    public Page<MeetingDues> findByMeetingId(Long meetingId, Pageable pageable) {
        return ((MeetingDuesRepository)this.getRepository()).findByMeetingId(meetingId, pageable);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingDuesRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
