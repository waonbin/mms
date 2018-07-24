package com.zlsoft.portal.web.controller;

import com.zlsoft.common.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {

    /**
     * GET  / : get index page
     * @return index page
     */
    @GetMapping("/")
    public String index() {
        return "/index";
    }
}
