package com.xrafece.dao.impl;

import com.xrafece.dao.UserDao;

/**
 * 多例对象
 * @author Xrafece
 */
public class UserDaoImplPrototype implements UserDao {

    /**
     * 修改无参构造方法，用来验证 Spring 容器创建 bean 时，默认使用无参构造方法。
     */
    public UserDaoImplPrototype() {
        System.out.println("UserDaoImplPrototype Constructor Method is running...");
    }

    /**
     * 模拟存储 User 对象
     */
    @Override
    public void saveUser() {
        System.out.println("UserDaoImplPrototype User is saving...");
    }

}
