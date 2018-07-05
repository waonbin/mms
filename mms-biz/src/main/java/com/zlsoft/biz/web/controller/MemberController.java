package com.zlsoft.biz.web.controller;

import com.zlsoft.biz.Constants;
import com.zlsoft.biz.domain.Member;
import com.zlsoft.biz.service.MemberService;
import com.zlsoft.utils.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    @Inject
    private MemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "member/register1";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(Member member) {
        member = this.memberService.save(member);
        Map<String, Member> data = new HashMap<>();
        data.put("member", member);
        return new ModelAndView("member/register3", data);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView info(HttpSession session) {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        Map<String, Member> data = new HashMap<>();
        data.put("member", member);
        return new ModelAndView("member/personal_information", data);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpSession session) {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        Map<String, Member> data = new HashMap<>();
        data.put("member", member);
        return new ModelAndView("member/personal_edit", data);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(Member member) {
        member = this.memberService.save(member);
        Map<String, Member> data = new HashMap<>();
        data.put("member", member);
        return new ModelAndView("member/personal_edit", data);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String payment() {
        return "member/personal_payment";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay() {
        return "member/personal_pay";
    }

    @RequestMapping(value = "/revise", method = RequestMethod.GET)
    public String revise() {
        return "member/personal_revise";
    }

}
