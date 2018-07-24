package com.zlsoft.portal.web.controller;

import com.zlsoft.common.CommonConstants;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.common.web.vm.MemberVM;
import com.zlsoft.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    /**
     * GET  /login : get login page
     * @return login page
     */
    @GetMapping("/login")
    public String login(){
        return "/member/login";
    }

    /**
     * GET  /logout : user logout
     * @param session the HTTP Session
     * @return user login page
     */
    @GetMapping("/s/logout")
    public String logout(HttpSession session){
        session.removeAttribute(CommonConstants.SESSION_USER);
        return "redirect:/login";
    }

    /**
     * GET  /login/user : get login user info
     * @param session the HTTP Session
     * @return login user info
     */
    @GetMapping("/login/user")
    public ResponseEntity getLoginUser(HttpSession session){

        MemberVM member = this.getCurrentUser(session);

        if(member == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(member);
    }
}
