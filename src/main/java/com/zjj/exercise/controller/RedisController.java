package com.zjj.exercise.controller;

import com.zjj.exercise.model.UserModel;
import com.zjj.exercise.service.UserService;
import com.zjj.exercise.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/redis")
@Controller
public class RedisController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/uu")
    @ResponseBody
    @Cacheable(value = "thisredis",key = "'users_'+#username")
    public Object findUser(String username){
        UserModel ud = userService.queryUser(username);
        return ud;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Object findUser2(String username){
        System.out.println("this is redis user controller中。。。 ："+username);
        UserModel ud = userService.queryUser(username);
        redisUtil.set(username,ud);
        return ud;
    }

}
