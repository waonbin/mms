package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingHotelRepository;
import com.zlsoft.common.service.MeetingHotelService;
import com.zlsoft.domain.MeetingHotel;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("meetingHotelService")
public class MeetingHotelServiceImpl extends BaseSimpleService<MeetingHotel, Long> implements MeetingHotelService {

    @Override
    public List<MeetingHotel> findByMeetingId(Long meetingId) {
        return ((MeetingHotelRepository)this.getRepository()).findByMeetingId(meetingId);
    }

    @Override
    public void deleteByMeetingId(Long meetingId) {
        ((MeetingHotelRepository)this.getRepository()).deleteByMeetingId(meetingId);
    }
}
