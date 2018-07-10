package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String individualMembers() {
        return "/admin/member/individual_members";
    }

    /**
     * GET  /personal_information/data : get data of individual members' list page
     * @return data of individual members' list page
     */
    @GetMapping("/individual_members/data")
    public @ResponseBody List<Member>
    getIndividualMembers() {
        List<Member> members = this.memberService.findAll();
        return members;
    }

    /**
     * GET  /group_members : get group members' list page
     * @return group members' list page
     */
    @GetMapping("/group_members")
    public String groupMembers() {
        return "/admin/member/group_members";
    }

    /**
     * GET  /group_members/data : get data of group members' list page
     * @return data of group members' list page
     */
    @GetMapping("/group_members/data")
    public @ResponseBody List<Member> getGroupMembers() {
        List<Member> members = this.memberService.findAll();
        return members;
    }

    /**
     * GET  /personal_information : get group members' list page
     * @return group members' list page
     */
    @GetMapping("/register_check")
    public String registerCheck() {
        return "/admin/member/register_check";
    }

    /**
     * GET  /register_check/data : get data of group members' list page
     * @return data of group members' list page
     */
    @GetMapping("/register_check/data")
    public @ResponseBody List<Member> getRegisterCheck() {
        List<Member> members = this.memberService.findAll();
        return members;
    }
}
