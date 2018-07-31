package com.zlsoft.manager.web.rest;

import com.zlsoft.common.service.MeetingRegisterService;
import com.zlsoft.vm.RegisterVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/meeting")
public class AttendResource {

    @Inject
    private MeetingRegisterService meetingRegisterService;

    /**
     * POST  /register : user meeting register interface
     * @param registerVM register info
     * @return registered info
     */
    @PostMapping("/register")
    public ResponseEntity register(RegisterVM registerVM) {
        registerVM = this.meetingRegisterService.save(registerVM);
        return ResponseEntity.ok(registerVM);
    }
}
