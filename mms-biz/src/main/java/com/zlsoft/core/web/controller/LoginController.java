package com.zlsoft.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "member/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password){
        return new ModelAndView("member/personal_information");
    }
}
