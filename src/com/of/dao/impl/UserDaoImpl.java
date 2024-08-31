package com.of.dao.impl;

import com.of.dao.UserDao;
import com.of.entity.User;
import com.of.service.UserService;
import com.of.service.impl.UserServiceImpl;

public class UserDaoImpl implements UserDao {
    private static UserService userService = new UserServiceImpl();

    @Override
    public void showMessage(User user) {
        userService.showMessage(user);
    }

    @Override
    public void checkAge(int age) {
        userService.checkAge(age);
    }
}
