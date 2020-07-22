package com.xrafece.dao.impl;

import com.xrafece.dao.UserDao;

/**
 * 生命周期
 * @author Xrafece
 */
public class UserDaoImplLifeCycle implements UserDao {

    /**
     * 修改无参构造方法，用来验证 Spring 容器创建 bean 时，默认使用无参构造方法。
     */
    public UserDaoImplLifeCycle() {
        System.out.println("UserDaoImplLifeCycle Constructor Method is running...");
    }

    /**
     * 模拟存储 User 对象
     */
    @Override
    public void saveUser() {
        System.out.println("UserDaoImplLifeCycle User is saving...");
    }

    /**
     * 初始化方法
     */
    public void init() {
        System.out.println("Init...");
    }

    /**
     * 销毁方法
     */
    public void destroy() {
        System.out.println("Destroy...");
    }
}
