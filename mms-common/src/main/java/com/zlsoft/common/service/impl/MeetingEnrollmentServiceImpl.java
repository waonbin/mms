package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingEnrollmentService;
import com.zlsoft.domain.MeetingEnrollment;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingEnrollmentService")
public class MeetingEnrollmentServiceImpl extends BaseSimpleService<MeetingEnrollment, Long> implements MeetingEnrollmentService {
}
