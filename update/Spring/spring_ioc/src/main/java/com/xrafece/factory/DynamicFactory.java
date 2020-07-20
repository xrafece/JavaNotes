package com.xrafece.factory;

import com.xrafece.dao.UserDao;
import com.xrafece.dao.impl.UserDaoImpl;

/**
 * @author Xrafece
 */
public class DynamicFactory {
    public UserDao getUserDao() {
        UserDao userDao = new UserDaoImpl();
        System.out.println("UserDao is made in Dynamic Factory.");
        return userDao;
    }
}
