package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MeetingEnrollmentService;
import com.zlsoft.domain.MeetingEnrollment;
import com.zlsoft.manager.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Optional;

@Controller("AdminEnrollmentController")
@RequestMapping("/meeting/enroll")
public class EnrollmentController {

    @Inject
    private MeetingEnrollmentService meetingEnrollmentService;

    /**
     * GET  / : get meeting enrollment list page
     * @return meeting enrollment list page
     */
    @GetMapping
    public String getPage() {
        return "/meeting/enroll/list";
    }

    /**
     * GET  /page/{page} : get data of meetings by page
     * @param page zero-based page index
     * @return data of meetings by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity getMeetings(@PathVariable("page") int page){

        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<MeetingEnrollment> enrollments = this.meetingEnrollmentService.findAll(pageRequest);

        return ResponseEntity.ok(enrollments);
    }

    /**
     * GET  /detail : get details of meeting enrollment
     * @param id meeting enrollment id
     * @return meeting enrollment data
     */
    @GetMapping("/details")
    public @ResponseBody ResponseEntity getMeetingEnrollment(long id){
        Optional<MeetingEnrollment> enrollment = this.meetingEnrollmentService.findById(id);
        return ResponseEntity.ok(enrollment);
    }

    /**
     * POST  /delete : delete meeting enrollment by id
     * @param id meeting enrollment id
     * @return HTTP status to figure if operation is successful
     */
    public @ResponseBody ResponseEntity delete(long id) {
        this.meetingEnrollmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
