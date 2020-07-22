package com.xrafece.factory;

import com.xrafece.dao.UserDao;
import com.xrafece.dao.impl.UserDaoImplStatic;

/**
 * 静态工厂类
 *
 * @author Xrafece
 */
public class StaticFactory {

    /**
     * 模拟静态工厂实例化对象
     *
     * @return UserDao接口实现类对象
     */
    public static UserDao getUserDaoStatic() {
        UserDao userDao = new UserDaoImplStatic();
        System.out.println("UserDao is be made by Static factory.");
        return userDao;
    }
}
