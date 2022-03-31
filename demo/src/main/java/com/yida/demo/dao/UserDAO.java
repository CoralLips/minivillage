package com.yida.demo.dao;

import com.yida.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findUserByAccount(String account);
    User findUserByAccountAndPassword(String account, String password);
    User findUserByAccountAndName(String account, String name);
}
