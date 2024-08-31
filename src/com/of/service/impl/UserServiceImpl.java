package com.of.service.impl;

import com.of.entity.User;
import com.of.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void showMessage(User user) {
        System.out.println(user);
    }

    @Override
    public void checkAge(int age) {
        if (age < 0 || age > 130) {
            System.out.println("不可能!!绝对不可能!!");
        }
    }
}
