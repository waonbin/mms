package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MeetingService;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.domain.Meeting;
import com.zlsoft.manager.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller("AdminMeetingController")
@RequestMapping("/admin/meeting")
public class MeetingController extends BaseController {

    @Inject
    private MeetingService meetingService;

    /**
     * GET  / : get meetings' list page
     * @return meetings' list page
     */
    @GetMapping
    public String getMeetingPage() {
        return "/admin/meeting/list";
    }

    /**
     * GET  /add : get add meeting page
     * @return add meeting page
     */
    @GetMapping("/add")
    public String getAddMeetingPage() {
        return "/admin/meeting/add";
    }

    /**
     * GET  /add : get modify meeting page
     * @return modify meeting page
     */
    @GetMapping("/modify")
    public String getModifyMeetingPage() {
        return "/admin/meeting/modify";
    }

    /**
     * GET  /page/{page} : get data of meetings by page
     * @param page zero-based page index
     * @return data of meetings by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity getMeetings(@PathVariable("page") int page){
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Meeting> meetings = this.meetingService.findAll(pageRequest);
        return ResponseEntity.ok(meetings);
    }

    /**
     * POST  /save : save meeting data
     * @param meeting meeting data to be saved
     * @return saved meeting data
     */
    @PostMapping("/save")
    public @ResponseBody ResponseEntity save(Meeting meeting) {
        Meeting savedMeeting = this.meetingService.save(meeting);
        return ResponseEntity.ok(savedMeeting);
    }

    /**
     * POST  /delete : delete meeting data
     * @param id meeting id
     * @return HTTP status to figure if operation is successful
     */
    @PostMapping("/delete")
    public @ResponseBody ResponseEntity delete(long id) {
        this.meetingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
