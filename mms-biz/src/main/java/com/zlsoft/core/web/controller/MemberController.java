package com.zlsoft.core.web.controller;

import com.zlsoft.core.domain.Member;
import com.zlsoft.core.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    @Inject
    private MemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "member/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Member member) {
        this.memberService.save(member);
        return "member/register3";
    }
}
