package com.zjj.exercise.controller;

import com.zjj.exercise.model.UserModel;
import com.zjj.exercise.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //static Map<Long,UserModel> users = Collections.synchronizedMap(new HashMap<Long,UserModel>());

    @GetMapping("/getMapping")
    public String getIn(){
        return "this is getMapping";
    }
    @PostMapping("/getMapping")
    public String postIn(){
        return "this is postMapping same param";
    }
    @PostMapping("/postMapping")
    public String postIn2(){
        return "this is postMapping";
    }


    /**
     * /user/  的get请求
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<UserModel> getUserList(){
        logger.info("get请求：/user/");
        List<UserModel> uu = userService.queryAll();
        return uu;
    }

    /**
     * /user/  的请求
     * @param userModel
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute UserModel userModel){
       logger.info("post请求：/user/   "+userModel);
        userService.addUser(userModel);
        return "success";
    }

    /**
     * /user/zjj   的get请求
     * @param username    用户名
     * @return
     */
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public UserModel getUserByUserName(@PathVariable String username){
        logger.info("get请求：/user/username   "+username);
        UserModel ud =  userService.queryUser(username);
        return ud;
    }


    @RequestMapping("/removeUser")
    public void removeUser(String username){
        System.out.println("this is removeUser controller:  "+username);
        userService.removeUser(username);
    }
    @RequestMapping("/queryUser")
    public Object getUser(String username){
        System.out.println("this is queryUser controller:  "+username);
        return userService.queryUser(username);
    }
}
