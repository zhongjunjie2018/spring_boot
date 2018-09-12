package com.zjj.exercise;

import com.zjj.exercise.model.UserModel;
import com.zjj.exercise.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;
    @Test
    public void addUser(){
        UserModel user = new UserModel();
        user.setUsername("jmx");
        user.setPassword("123456");
        user.setAge(20);
        userService.addUser(user);
    }
}
