package com.zlsoft.utils.web.controller;

import com.zlsoft.utils.domain.Member;
import com.zlsoft.utils.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;

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
    public @ResponseBody
    ResponseEntity register(Member member) throws URISyntaxException {
        member = this.memberService.save(member);
        return ResponseEntity.created(new URI("member/register3")).body(member);
    }
}
