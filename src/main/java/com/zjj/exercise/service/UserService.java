package com.zjj.exercise.service;

import com.zjj.exercise.model.UserModel;

import java.util.List;


public interface UserService {

    void addUser(UserModel ud);

    void removeUser(String username);

    UserModel queryUser(String username);

    List<UserModel> queryAll();
}
