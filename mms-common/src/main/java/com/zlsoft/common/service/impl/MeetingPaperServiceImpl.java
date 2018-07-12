package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.MeetingPaperService;
import com.zlsoft.domain.MeetingPaper;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("meetingPaperService")
public class MeetingPaperServiceImpl extends BaseSimpleService<MeetingPaper, Long> implements MeetingPaperService {
}
