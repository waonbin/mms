package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
import com.zlsoft.manager.Constants;
import com.zlsoft.utils.MD5Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller(value = "AdminLoginController")
@RequestMapping("/admin")
public class LoginController {

    @Inject
    private MemberService memberService;

    /**
     * GET  /login : get login page
     * @return login page
     */
    @GetMapping("/login")
    public String login(){
        return "/admin/login";
    }

    /**
     * POST  /login : user login
     * @param session the HTTP Session
     * @param member member information
     * @return if login successfully redirect to personal information page; otherwise output error information
     * @throws URISyntaxException
     */
    @PostMapping("/login")
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
                return ResponseEntity.created(new URI("/admin/personal_information")).body(memberInDB);
            }

        }
    }

    /**
     * GET  /logout : user logout
     * @param session the HTTP Session
     * @return user login page
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.SESSION_USER);
        return "/admin/login";
    }

    /**
     * GET  /login/user : get login user info
     * @param session the HTTP Session
     * @return login user info
     */
    @GetMapping("/login/user")
    public ResponseEntity getLoginUser(HttpSession session){
        return ResponseEntity.ok(session.getAttribute(Constants.SESSION_USER));
    }
}
