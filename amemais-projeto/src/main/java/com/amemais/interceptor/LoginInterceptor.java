package com.amemais.interceptor;

import com.amemais.model.Administrator;
import com.amemais.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserSession userSession;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        Administrator administrator = userSession.getLoggedAdmin();
        Client client = userSession.getLoggedClient();
        if(administrator != null) {
            return true;
        } else if (client != null && url.contains("/client/listExamsClient")) {
            return true;
        } else if (url.contains("/login/login")) {
            return true;
        }

        String loginPage = httpServletRequest.getContextPath() + "/login/login";
        httpServletResponse.sendRedirect(loginPage);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
