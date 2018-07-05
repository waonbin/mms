package com.zlsoft.utils.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "member/login";
    }



    @RequestMapping("/register2")
    public String register2() {
        return "member/register2";
    }

    @RequestMapping("/register3")
    public String register3() {
        return "member/register3";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "member/personal_edit";
    }

    @RequestMapping("/info")
    public String info() {
        return "member/personal_information";
    }

    @RequestMapping("/pay")
    public String pay() {
        return "member/personal_pay";
    }

    @RequestMapping("/payment")
    public String payment() {
        return "member/personal_payment";
    }

    @RequestMapping("/revise")
    public String revise() {
        return "member/personal_revise";
    }
}
