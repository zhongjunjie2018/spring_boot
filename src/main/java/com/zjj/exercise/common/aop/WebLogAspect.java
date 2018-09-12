package com.zjj.exercise.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志代理
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.zjj.exercise.controller.*.*(..))")
    public void webLog(){}

    //@Before("webLog()")
    //public void doBefore(JoinPoint joinPoint) throws Throwable {
        //startTime.set(System.currentTimeMillis());

        // 省略日志记录内容
    //}


    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer sb = new StringBuffer();
        sb.append("用户IP:[").append(request.getRemoteAddr()).append("]").
                append("访问接口：[").append(request.getRequestURL().toString()).append("]").
                append("相应DATA[").append(ret).append("]");
        logger.info(sb);
        // 记录下请求内容
        //logger.info("URL : " + request.getRequestURL().toString());
        //logger.info("IP : " + request.getRemoteAddr());
        //logger.info("RESPONSE : " + ret);
        //logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

}


















