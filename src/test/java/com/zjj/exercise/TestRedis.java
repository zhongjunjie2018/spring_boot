package com.zjj.exercise;


import com.zjj.exercise.model.UserModel;
import com.zjj.exercise.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRemove(){

        redisUtil.remove("time");
        //Object o = redisUtil.get("ceshi");
        //System.out.println(o);
    }
    @Test
    public void testGet(){
        String key = "nba";
        //UserModel ud = (UserModel) redisUtil.get(key);
        System.out.println(redisUtil.get(key));
    }
    @Test
    public void testSetR(){
        String key = "nba";
        String vaue = "ddd";
        Boolean bo = redisUtil.set(key,vaue);
        System.out.println("插入结果："+bo);
    }
    @Test
    public void testRedisTime(){
        String key = "ceshi";
        String value = "ABCD";
        Long time = 60L;
       //Boolean bo = redisUtil.set(key,value,time);
       Boolean bo = redisUtil.set(key,value);
       System.out.println("设置时间："+bo);
    }
}
