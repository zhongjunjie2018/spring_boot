package com.zjj.exercise.dao;


import com.zjj.exercise.model.UserModel;

import java.util.List;

public interface UserDAO {

    void insertUser(UserModel ud);

    void deleteUser(String username);

    UserModel selectUser(String username);

    List<UserModel> selectAll();

}
