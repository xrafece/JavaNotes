package com.xrafece.factory;

import com.xrafece.dao.UserDao;
import com.xrafece.dao.impl.UserDaoImplDynamic;

/**
 * 实例工厂类
 *
 * @author Xrafece
 */
public class DynamicFactory {
    /**
     * 模拟实例工厂实例化对象
     *
     * @return UserDao接口实现类对象
     */
    public UserDao getUserDaoDynamic() {
        UserDao userDao = new UserDaoImplDynamic();
        System.out.println("UserDao is made in Dynamic Factory.");
        return userDao;
    }
}
