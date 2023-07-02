package com.demofilters.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
@Order(1)
public class Filter1 implements Filter {
    public Filter1() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init is called filter 1");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("i am running with every request...filter 1");
        HttpServletRequest req= (HttpServletRequest) servletRequest;

        String uri=req.getRequestURI();
        System.out.println("uri req: "+ uri);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("dest is called filter1");
    }
}
