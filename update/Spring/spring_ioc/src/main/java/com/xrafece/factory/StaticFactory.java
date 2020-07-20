package com.xrafece.factory;

import com.xrafece.dao.UserDao;
import com.xrafece.dao.impl.UserDaoImpl;

/**
 * @author Xrafece
 */
public class StaticFactory {
    public static UserDao getUserDao() {
        UserDao userDao = new UserDaoImpl();
        System.out.println("UserDao is be made by Static factory.");
        return userDao;
    }
}
