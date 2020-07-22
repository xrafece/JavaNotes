package com.xrafece.service.impl;

import com.xrafece.dao.UserDao;
import com.xrafece.service.UserService;

/**
 * UserService 接口实现类
 * @author Xrafece
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    /**
     * 通过 set 进行依赖注入
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 使用依赖注入以后的 UserDao 接口实现类对象，验证依赖注入是否成功
     */
    @Override
    public void saveUser() {
        System.out.println("UserService run saveUser method.");
        userDao.saveUser();
        System.out.println("UserService run userDao's saveUser method.");
    }
}
