package com.zlsoft.common.service;

import com.zlsoft.domain.MeetingRegister;
import com.zlsoft.utils.service.SimpleService;
import com.zlsoft.vm.RegisterVM;

public interface MeetingRegisterService extends SimpleService<MeetingRegister, Long> {
    RegisterVM save(RegisterVM registerVM);
}
