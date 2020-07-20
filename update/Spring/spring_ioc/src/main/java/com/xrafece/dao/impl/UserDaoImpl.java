package com.xrafece.dao.impl;

import com.xrafece.dao.UserDao;

/**
 * @author Xrafece
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("Constructor Method is running...");
    }

    public void init() {
        System.out.println("Init...");
    }

    public void destroy() {
        System.out.println("Destroy...");
    }


    @Override
    public void saveUser() {
        System.out.println("User is saving...");
    }
}
