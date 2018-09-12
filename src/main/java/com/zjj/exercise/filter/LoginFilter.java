package com.zjj.exercise.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class LoginFilter implements Filter {

    private static Logger logger = Logger.getLogger(LoginFilter.class);

    //不用过滤的URL
    private static Set<String> GreenUrl = new HashSet<String>();

    /**
     * 初始化不需要过滤的url
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("自定义过滤器启动......");
        //GreenUrl.add("/");
        //GreenUrl.add("/js");
        //GreenUrl.add("/picture");
        //GreenUrl.add("/image");
        //GreenUrl.add("/css");
        GreenUrl.add("/index");//项目的默认页面
        GreenUrl.add("/favicon.ico");//spring boot的标志
        GreenUrl.add("/thymeleaf/list");
        GreenUrl.add("/");

    }
    /**
     * 过滤器的核心处理逻辑
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //request
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //response
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = (String)request.getRequestURI();

        //System.out.println("访问链接："+url);
        boolean exclude = false;

        //查看访问的链接是不是不需要进行登陆的
        for(String str:GreenUrl){
            //System.out.println("rrr: "+request.getContextPath()+str);
            if(url.startsWith(request.getContextPath()+str)){
                exclude = true;
                break;
            }
        }
        /**
         * exclude = true 不需要登陆的  直接跳转
         *
         * exclude = false 需要登陆  查看session
         *      session 存在    说明登陆
         *      session 不存在  说明没有进行登陆  跳转到登陆或者index页面
         */
        if(!exclude){
            HttpSession session = request.getSession();
            //System.out.println("session: "+session.getAttribute("SESSION_USER"));
            if(session.getAttribute("SESSION_USER")!=null){

            }else if(session.getAttribute("SESSION_USER")==null){
                logger.info("loginFilter:[need to login]");
                response.sendRedirect("/index");
                return;
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
