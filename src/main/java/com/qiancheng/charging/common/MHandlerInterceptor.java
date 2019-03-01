package com.qiancheng.charging.common;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class MHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = SessionContext.getSession(request.getSession().getId());
        if (null != session && null != session.getAttribute("userMsg")) {
            return true;
        } else {
            PrintWriter out = response.getWriter();
            JSONObject json = JSONObject.fromObject(ServerResponse.createByErrorMessage("Session失效"));
            out.print(json);
            out.flush();
            out.close();
            return false;
        }
//        System.out.println("进入拦截器");
//        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
