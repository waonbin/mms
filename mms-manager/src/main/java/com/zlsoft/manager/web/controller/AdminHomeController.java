package com.zlsoft.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
}
