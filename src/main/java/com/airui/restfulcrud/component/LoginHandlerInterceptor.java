package com.airui.restfulcrud.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截
 * @author dangbaoqi
 * @date 2019/10/31-11:54
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(null == user){
            //未登录  返回登录页面
            request.setAttribute("msg","请先登录......");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else{
            //已登录，放行请求
            return true;
        }
    }

}
