package com.zjj.exercise.serviceImpl;

import com.zjj.exercise.dao.UserDAO;
import com.zjj.exercise.model.UserModel;
import com.zjj.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(UserModel ud) {
        userDAO.insertUser(ud);
    }


    @Override
    public void removeUser(String username) {
        userDAO.deleteUser(username);
    }


    @Override
    public UserModel queryUser(String username) {
        //System.out.println("查询user的service中："+username);
        return userDAO.selectUser(username);
    }

    @Override
    public List<UserModel> queryAll() {
        return userDAO.selectAll();
    }
}
