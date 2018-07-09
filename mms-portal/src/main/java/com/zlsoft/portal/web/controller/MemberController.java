package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
import com.zlsoft.portal.Constants;
import com.zlsoft.utils.MD5Util;
import com.zlsoft.utils.web.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/register")
    public String register() {
        return "/member/register1";
    }

    /**
     * POST  /register : register member
     * @param member member info
     * @return register success page
     * @throws URISyntaxException
     */
    @PostMapping("/register")
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
    @GetMapping("/register3")
    public String register3() {
        return "/member/register3";
    }

    /**
     * GET  /check/email : check if email is already registered
     * @param email the Email address
     * @return HTTP Status with information
     */
    @GetMapping("/check/email")
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
    @GetMapping("/check/name")
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
     * GET  /check/password : check if password is already registered
     * @param session the HTTP Session
     * @param password the user password
     * @return HTTP Status with information
     */
    @GetMapping("/check/password")
    public @ResponseBody
    ResponseEntity checkPassword(HttpSession session, String password){
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        String passwordEncoded = MD5Util.getMD5WithBase64(password);

        if(!member.getPassword().equals(passwordEncoded)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密码错误！");
        } else {
            return ResponseEntity.ok().build();
        }
    }

    /**
     * GET  /personal_information : get personal information page
     * @param session the HTTP Session
     * @return personal information page with data
     */
    @GetMapping("/personal_information")
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
    @GetMapping("/edit")
    public ModelAndView edit(HttpSession session) {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        ModelAndView mav = new ModelAndView("/member/personal_edit");
        mav.addObject("member", member);
        return mav;
    }

    /**
     * POST  /edit : edit personal information
     * @param member member information
     * @return personal information edit page
     * @throws URISyntaxException
     */
    @PostMapping("/edit")
    public ResponseEntity edit(Member member) throws URISyntaxException {
        String password = MD5Util.getMD5WithBase64(member.getPassword());
        member.setPassword(password);
        member = this.memberService.save(member);
        return ResponseEntity.created(new URI("/member/personal_edit")).body(member);
    }

    /**
     * GET  /revise : get revise page
     * @return revise page
     */
    @GetMapping("/revise")
    public String revise() {
        return "/member/personal_revise";
    }


    /**
     * POST  /password : change password
     * @param session the HTTP Session
     * @param newPassword new password
     * @return HTTP Status with information
     */
    @PostMapping("/password")
    public ResponseEntity changePassword(HttpSession session, String newPassword){
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        String passwordEncoded = MD5Util.getMD5WithBase64(newPassword);
        member.setPassword(passwordEncoded);

        this.memberService.save(member);
        session.setAttribute(Constants.SESSION_USER, member);

        return ResponseEntity.ok().build();
    }

}
