package com.roadjava.statistic.interceptor;

import com.roadjava.statistic.bean.entity.Admin;
import com.roadjava.statistic.config.AuthorizationProperties;
import com.roadjava.statistic.util.Constants;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Resource
    private AuthorizationProperties authorizationProperties;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
        if (admin == null) {
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
        return true;
    }
}
