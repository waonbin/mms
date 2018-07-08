package com.zlsoft.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "AdminHomeController")
@RequestMapping("/admin")
public class HomeController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

}
