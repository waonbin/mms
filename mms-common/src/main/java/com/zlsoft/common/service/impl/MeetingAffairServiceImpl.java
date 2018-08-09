package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingAffairRepository;
import com.zlsoft.common.service.MeetingAffairService;
import com.zlsoft.domain.MeetingAffair;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingAffairService")
public class MeetingAffairServiceImpl extends BaseSimpleService<MeetingAffair, Long> implements MeetingAffairService {

    @Override
    public Page<MeetingAffair> findByMeetingId(Long meetingId, Pageable pageable) {
        return ((MeetingAffairRepository)this.getRepository()).findByMeetingId(meetingId, pageable);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingAffairRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
