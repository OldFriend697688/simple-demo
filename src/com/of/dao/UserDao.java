package com.of.dao;

import com.of.entity.User;

public interface UserDao {
    void showMessage(User user);

    void checkAge(int age);
}
