package com.zlsoft.manager.web.controller;

import com.zlsoft.common.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "AdminHomeController")
@RequestMapping("/admin")
public class HomeController extends BaseController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

}
