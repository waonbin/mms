package com.zlsoft.common.web.controller;

import com.zlsoft.common.CommonConstants;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.web.vm.MemberVM;
import com.zlsoft.security.SecurityUtils;
import org.springframework.web.context.ServletContextAware;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class BaseController implements ServletContextAware  {

    private ServletContext servletContext;

    @Inject
    private MemberService memberService;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected ServletContext getServletContext() {
        return servletContext;
    }

    protected MemberVM getCurrentUser(HttpSession session) {

        Object sessionInfo = session.getAttribute(CommonConstants.SESSION_USER);

        if(sessionInfo != null) {
            return (MemberVM) sessionInfo;
        } else {
            Optional<String> username = SecurityUtils.getCurrentUserLogin();

            if(username.isPresent()) {
                MemberVM member = this.memberService.findByLogin(username.get());
                session.setAttribute(CommonConstants.SESSION_USER, member);
                return member;
            } else {
                return null;
            }
        }
    }
}
