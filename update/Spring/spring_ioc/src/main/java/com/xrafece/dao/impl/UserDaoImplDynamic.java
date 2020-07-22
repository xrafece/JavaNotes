package com.xrafece.dao.impl;

import com.xrafece.dao.UserDao;

/**
 * @author Xrafece
 */
public class UserDaoImplDynamic implements UserDao {

    /**
     * 修改无参构造方法，用来验证 Spring 容器创建 bean 时，默认使用无参构造方法。
     */
    public UserDaoImplDynamic() {
        System.out.println("UserDaoImplDynamic Constructor Method is running...");
    }

    /**
     * 模拟存储 User 对象
     */
    @Override
    public void saveUser() {
        System.out.println("UserDaoImplDynamic User is saving...");
    }

}
