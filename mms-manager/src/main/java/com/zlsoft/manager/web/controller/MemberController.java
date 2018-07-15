package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
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
    public @ResponseBody ResponseEntity getIndividualMembers() {
        List<Member> members = this.memberService.findAll();
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /page/{page} : get data of members by page
     * @param page zero-based page index
     * @param memberType member type code
     * @return data of members by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity getMembers(@PathVariable("page") int page, short memberType) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Member> members = this.memberService.findByMemberType(memberType, pageRequest);
        return ResponseEntity.ok(members);
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
    public @ResponseBody ResponseEntity getGroupMembers() {
        List<Member> members = this.memberService.findAll();
        return ResponseEntity.ok(members);
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
    public @ResponseBody ResponseEntity getRegisterCheck() {
        List<Member> members = this.memberService.findAll();
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /register_check/page/{page} : get data of members by page
     * @param page zero-based page index
     * @return data of members by page
     */
    @GetMapping("/register_check/page/{page}")
    public @ResponseBody ResponseEntity getRegisterCheck(@PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Member> members = this.memberService.findAll(pageRequest);
        return ResponseEntity.ok(members);
    }
}
