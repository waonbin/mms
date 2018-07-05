package com.zlsoft.utils.web.controller;

import com.zlsoft.utils.MD5Util;
import com.zlsoft.utils.domain.Member;
import com.zlsoft.utils.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
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
    ResponseEntity login(Member member) throws URISyntaxException {

        String password = MD5Util.getMD5WithBase64(member.getPassword());
        List<Member> members = memberService.findByNameAndPassword(member.getName(), password);

        if(members.size() != 1)
        {
            return ResponseEntity.badRequest().build();
        }
        else
        {
            return ResponseEntity.created(new URI("member/personal_information")).body(members);
        }
    }
}
