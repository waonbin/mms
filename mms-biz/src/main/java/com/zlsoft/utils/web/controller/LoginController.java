package com.zlsoft.utils.web.controller;

import com.zlsoft.utils.MD5Util;
import com.zlsoft.utils.domain.Member;
import com.zlsoft.utils.service.MemberService;
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
import java.util.Optional;

@Controller
public class LoginController {

    @Inject
    private MemberService memberService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "member/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity login(HttpSession session, Member member) throws URISyntaxException {

        List<Member> members = memberService.findByName(member.getName());

        if(members.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的用户不存在！");
        }
        else {
            Member memberInDB = members.get(0);
            String password = MD5Util.getMD5WithBase64(member.getPassword());

            if(!memberInDB.getPassword().equals(password)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的密码错误！");
            } else {
                session.setAttribute("USER_INFO", memberInDB);
                return ResponseEntity.created(new URI("member/personal_information")).body(member);
            }

        }
    }
}
