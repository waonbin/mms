package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.AdministrativeDivisionService;
import com.zlsoft.domain.AdministrativeDivision;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("administrativeDivisionService")
public class AdministrativeDivisionServiceImpl extends BaseSimpleService<AdministrativeDivision, Long> implements AdministrativeDivisionService {
}
