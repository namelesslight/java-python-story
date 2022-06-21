package com.example.javapythonstory.code.filter;

import com.example.javapythonstory.code.util.JWTUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置跨域的监听器
 */
//@WebFilter("*")
public class SimpleCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
        chain.doFilter(request, response);
        String token =req.getHeader("Token");
        if (token == null || "".equals(token)){
            return;
        } else {
            Integer code = JWTUtil.verify(token);
            if (code == 1){
                String role = JWTUtil.getString(token,"role");
                if (!("common".equals(role) | "super".equals(role))){
                    return;
                }
            } else if (code == -1){
                return;
            } else if (code == -2){
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
