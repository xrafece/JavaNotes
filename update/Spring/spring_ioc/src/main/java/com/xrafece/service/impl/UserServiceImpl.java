package com.xrafece.service.impl;

import com.xrafece.dao.UserDao;
import com.xrafece.service.UserService;

/**
 * @author Xrafece
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        System.out.println("UserService run saveUser method.");
        userDao.saveUser();
        System.out.println("UserService run userDao's saveUser method.");
    }
}
