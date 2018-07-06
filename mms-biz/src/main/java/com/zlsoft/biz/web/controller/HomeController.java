package com.zlsoft.biz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * GET  / : get index page
     * @return index page
     */
    @RequestMapping("/")
    public String index() {
        return "/index";
    }
}
