package com.zlsoft.biz.web.controller;

import com.zlsoft.biz.Constants;
import com.zlsoft.biz.domain.Member;
import com.zlsoft.biz.service.MemberService;
import com.zlsoft.utils.MD5Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class LoginController {

    @Inject
    private MemberService memberService;

    /**
     * GET  /login : get login page
     * @return login page
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "/member/login";
    }

    /**
     * POST  /login : user login
     * @param session the HTTP Session
     * @param member member information
     * @return if login successfully redirect to personal information page; otherwise output error information
     * @throws URISyntaxException
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity login(HttpSession session, Member member) throws URISyntaxException {

        List<Member> members = memberService.findByNameOrEmail(member.getName(), member.getName());

        if(members.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的用户名不存在！");
        }
        else {
            Member memberInDB = members.get(0);
            String password = MD5Util.getMD5WithBase64(member.getPassword());

            if(!memberInDB.getPassword().equals(password)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的密码错误！");
            } else {
                session.setAttribute(Constants.SESSION_USER, memberInDB);
                return ResponseEntity.created(new URI("/member/personal_information")).body(memberInDB);
            }

        }
    }
}
