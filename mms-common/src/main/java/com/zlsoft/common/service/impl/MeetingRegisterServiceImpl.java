package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MeetingRegisterExtRepository;
import com.zlsoft.common.service.MeetingRegisterService;
import com.zlsoft.domain.MeetingRegister;
import com.zlsoft.domain.MeetingRegisterExt;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import com.zlsoft.vm.RegisterVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Transactional
@Service("meetingRegisterService")
public class MeetingRegisterServiceImpl extends BaseSimpleService<MeetingRegister, Long> implements MeetingRegisterService {

    @Inject
    private MeetingRegisterExtRepository meetingRegisterExtRepository;

    @Override
    public RegisterVM save(RegisterVM registerVM) {

        MeetingRegister meetingRegister = registerVM.getMeetingRegister();

        meetingRegister = this.save(meetingRegister);

        MeetingRegisterExt meetingRegisterExt = registerVM.getMeetingRegisterExt();

        meetingRegisterExt.setId(meetingRegister.getId());

        meetingRegisterExt = this.meetingRegisterExtRepository.save(meetingRegisterExt);

        return new RegisterVM(meetingRegister, meetingRegisterExt);
    }
}
