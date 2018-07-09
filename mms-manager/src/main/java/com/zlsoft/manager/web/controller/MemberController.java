package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller(value = "AdminMemberController")
@RequestMapping("/admin/member")
public class MemberController {

    @Inject
    private MemberService memberService;

    /**
     * GET  /personal_information : get individual members' list page
     * @return individual members' list page
     */
    @GetMapping("/individual_members")
    public ModelAndView individualMembers() {
        List<Member> members = this.memberService.findAll();
        ModelAndView mav = new ModelAndView("/admin/member/individual_members");
        mav.addObject("members", members);
        return mav;
    }

    /**
     * GET  /personal_information : get group members' list page
     * @return group members' list page
     */
    @GetMapping("/group_members")
    public ModelAndView groupMembers() {
        List<Member> members = this.memberService.findAll();
        ModelAndView mav = new ModelAndView("/admin/member/group_members");
        mav.addObject("members", members);
        return mav;
    }

    /**
     * GET  /personal_information : get group members' list page
     * @return group members' list page
     */
    @GetMapping("/register_check")
    public ModelAndView registerCheck() {
        List<Member> members = this.memberService.findAll();
        ModelAndView mav = new ModelAndView("/admin/member/register_check");
        mav.addObject("members", members);
        return mav;
    }
}
