package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingService;
import com.zlsoft.domain.Meeting;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingService")
public class MeetingServiceImpl extends BaseSimpleService<Meeting, Long> implements MeetingService {
}
