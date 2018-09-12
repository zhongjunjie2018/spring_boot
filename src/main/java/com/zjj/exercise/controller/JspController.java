package com.zjj.exercise.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("this is jsp index Controller");
        return "index";
    }

    @RequestMapping("/login")
    public String home(){
        System.out.println("this is jsp login Controller");
        return "login";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String data(){
        return "data2";
    }
}
