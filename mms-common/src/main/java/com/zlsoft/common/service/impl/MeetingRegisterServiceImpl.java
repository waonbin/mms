package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingRegisterService;
import com.zlsoft.domain.MeetingRegister;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingRegisterService")
public class MeetingRegisterServiceImpl extends BaseSimpleService<MeetingRegister, Long> implements MeetingRegisterService {
}
