package com.zlsoft.portal.web.controller;

import com.zlsoft.portal.Constants;
import com.zlsoft.portal.domain.Member;
import com.zlsoft.portal.service.MemberService;
import com.zlsoft.utils.MD5Util;
import com.zlsoft.utils.web.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    @Inject
    private MemberService memberService;

    /**
     * GET  /register : get register page
     * @return register page
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/member/register1";
    }

    /**
     * POST  /register : register member
     * @param member member info
     * @return register success page
     * @throws URISyntaxException
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(Member member) throws URISyntaxException {
        String password = MD5Util.getMD5WithBase64(member.getPassword());
        member.setPassword(password);
        member = this.memberService.save(member);
        return ResponseEntity.created(new URI("/member/register3")).body(member);
    }

    /**
     * GET  /register3 : get register success page
     * @return register success page
     */
    @RequestMapping(value = "/register3", method = RequestMethod.GET)
    public String register3() {
        return "/member/register3";
    }

    /**
     * GET  /check/email : check if email is already registered
     * @param email the Email address
     * @return HTTP Status with information
     */
    @RequestMapping(value = "/check/email", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity checkEmail(String email){
        List<Member> members = this.memberService.findByEmail(email);

        if(members.size() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的邮箱已注册！");
        } else {
            return ResponseEntity.ok().build();
        }
    }

    /**
     * GET  /check/name : check if name is already registered
     * @param name the user name
     * @return HTTP Status with information
     */
    @RequestMapping(value = "/check/name", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity checkName(String name){
        List<Member> members = this.memberService.findByName(name);
        if(members.size() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的用户名已注册！");
        } else {
            return ResponseEntity.ok().build();
        }
    }

    /**
     * GET  /personal_information : get personal information page
     * @param session the HTTP Session
     * @return personal information page with data
     */
    @RequestMapping(value = "/personal_information", method = RequestMethod.GET)
    public ModelAndView info(HttpSession session) {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        ModelAndView mav = new ModelAndView("/member/personal_information");
        mav.addObject("member", member);
        return mav;
    }

    /**
     * GET  /edit : get personal information edit page
     * @param session the HTTP Session
     * @return personal information edit page
     * @throws URISyntaxException
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ResponseEntity edit(HttpSession session) throws URISyntaxException {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        return ResponseEntity.created(new URI("/member/personal_edit")).body(member);
    }

    /**
     * POST  /edit : edit personal information
     * @param member member information
     * @return personal information edit page
     * @throws URISyntaxException
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity edit(Member member) throws URISyntaxException {
        String password = MD5Util.getMD5WithBase64(member.getPassword());
        member.setPassword(password);
        member = this.memberService.save(member);
        return ResponseEntity.created(new URI("/member/personal_edit")).body(member);
    }

    /**
     * GET  /payment : get payment page
     * @return payment page
     */
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String payment() {
        return "/member/personal_payment";
    }

    /**
     * GET  /pay : get pay page
     * @return pay page
     */
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay() {
        return "/member/personal_pay";
    }

    /**
     * GET  /revise : get revise page
     * @return revise page
     */
    @RequestMapping(value = "/revise", method = RequestMethod.GET)
    public String revise() {
        return "/member/personal_revise";
    }

}
