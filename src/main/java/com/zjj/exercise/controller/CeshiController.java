package com.zjj.exercise.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zjj.exercise.model.UserModel;
import com.zjj.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/thymeleaf")
@Controller
public class CeshiController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/json",method = RequestMethod.GET)
    @ResponseBody
    public Object getJson(@RequestParam(required = false)String username){
      UserModel u =  userService.queryUser(username);
      System.out.println("json的接口："+username);
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("status","success");
      map.put("code",100);
      map.put("data",u);
      return map;
    }
    @RequestMapping("/string")
    @ResponseBody
    public String getStr(){
        return "idea is good!";
    }
    @RequestMapping("/jsonData")
    @ResponseBody
    public List<UserModel> json(){
        List<UserModel> ud = userService.queryAll();
        return ud;
    }
    @RequestMapping("/list")
    public String list(Model model){
        System.out.println("测试展示controller");
        List<UserModel> ud = userService.queryAll();
        model.addAttribute("users",ud);
        return "ceshi";
    }
    @RequestMapping("/toDelete")
    public String delete(String username){
        System.out.println("测试删除controller");
        userService.removeUser(username);
        //model.addAttribute("users",ud);
        return "redirect:/thymeleaf/list";
    }
    @RequestMapping("/toAdd")
    public String add(Model model){
        System.out.println("测试增加controller");
        UserModel ud = new UserModel();
        ud.setUsername("zjj");
        ud.setPassword("888888");
        ud.setAge(25);
        userService.addUser(ud);
        return "redirect:/thymeleaf/list";
    }

}
