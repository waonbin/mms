package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.PaperAuditService;
import com.zlsoft.domain.PaperAudit;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("paperAuditService")
public class PaperAuditServiceImpl extends BaseSimpleService<PaperAudit, Long> implements PaperAuditService {
}
