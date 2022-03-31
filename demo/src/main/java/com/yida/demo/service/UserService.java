package com.yida.demo.service;

import com.yida.demo.dao.UserDAO;
import com.yida.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 构造器注入
    final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getByAccount(String account) {
        return userDAO.findUserByAccount(account);
    }

    public boolean isExistByAccount(String account) {
        User user = getByAccount(account);
        return user != null;
    }

    public void addUser(User user) {
        userDAO.save(user);
    }

    public User getByAccountAndPassword(String account, String password) {
        return userDAO.findUserByAccountAndPassword(account, password);
    }

    public boolean isExistByAccountAndPassword(String account, String password) {
        User user = getByAccountAndPassword(account, password);
        return user != null;
    }

    public void updateUser(User user) {
        userDAO.saveAndFlush(user);
        return;
    }

    public User getByAccountAndName(String account, String name) {
        return userDAO.findUserByAccountAndName(account, name);
    }

}
