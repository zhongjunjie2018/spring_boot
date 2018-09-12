package com.zjj.exercise.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//@WebFilter(urlPatterns = "/*",filterName = "myLogFilter")
public class LogFilter implements Filter {

    private static Logger logger = Logger.getLogger(LogFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest re = (HttpServletRequest) servletRequest;
        String url = (String) re.getRequestURI();

        StringBuffer sb = new StringBuffer();
        sb.append("用户访问 IP[").append(RequestUtil.getIpAddr(re)).append("] URL: [").append(url).append("] DATA[");


        Map<String,String[]> param = re.getParameterMap();
        for (Map.Entry<String, String[]> entry : param.entrySet()) {
            sb.append(entry.getKey()).append(":");
            for (String value : entry.getValue()) {
                sb.append(value).append(";");
            }
        }
        sb.append("]");

        logger.info(sb.toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
