package com.zlsoft.award.web.controller;

import com.zlsoft.common.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "AwardHomeController")
@RequestMapping("/award")
public class HomeController extends BaseController {

    @GetMapping
    public String index() {
        return "award/index";
    }

}
