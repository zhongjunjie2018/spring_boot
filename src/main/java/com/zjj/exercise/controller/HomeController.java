package com.zjj.exercise.controller;

import com.zjj.exercise.common.exception.MyException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String hime(){
        logger.info("访问空白页面controller");
        return "index";
    }
    @RequestMapping("/index")
    public String index(){
        logger.info("这是index controller");
        return "index";
    }
    @RequestMapping("/home2")
    @ResponseBody
    public String home2(){
        System.out.println("this is home Controller");
        return "index";
    }

    @RequestMapping("/exception")
    public void  exceptionCon() throws Exception {
        throw new Exception("Exception");
    }
    @RequestMapping("/jsonException")
    public void  myExceptionCon() throws Exception {
        throw new MyException("自定义json异常类");
    }
    @RequestMapping("/classException")
    public void  classExceptionCon() throws Exception {
        throw new ClassNotFoundException("404路径错误");
    }
}
