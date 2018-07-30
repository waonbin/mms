package com.zlsoft.manager.web.controller;

import com.zlsoft.common.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminMeetingController")
@RequestMapping("/admin/meeting")
public class MeetingController extends BaseController {

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
     * GET  /add : get meeting details page
     * @return meeting details page
     */
    @GetMapping("/details")
    public String getMeetingDetailsPage() {
        return "/admin/meeting/details";
    }

    /**
     * GET  /add : get modify meeting page
     * @return modify meeting page
     */
    @GetMapping("/modify")
    public String getModifyMeetingPage() {
        return "/admin/meeting/modify";
    }


}
