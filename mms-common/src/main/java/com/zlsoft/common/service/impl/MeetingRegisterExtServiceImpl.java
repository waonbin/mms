package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingRegisterExtService;
import com.zlsoft.domain.MeetingRegisterExt;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingRegisterExtService")
public class MeetingRegisterExtServiceImpl extends BaseSimpleService<MeetingRegisterExt, Long> implements MeetingRegisterExtService {
}
