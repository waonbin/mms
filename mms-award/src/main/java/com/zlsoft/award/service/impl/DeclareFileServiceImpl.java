package com.zlsoft.award.service.impl;

import com.zlsoft.award.domain.DeclareFile;
import com.zlsoft.award.service.DeclareFileService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("declareFileService")
public class DeclareFileServiceImpl extends BaseSimpleService<DeclareFile, Long> implements DeclareFileService {
}
