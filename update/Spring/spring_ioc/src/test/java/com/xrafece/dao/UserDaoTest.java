package com.xrafece.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xrafece
 */
public class UserDaoTest {
    @Test
    public void testInitSpringIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.saveUser();
        UserDao anotherUserDao = context.getBean("userDao", UserDao.class);
        System.out.println(anotherUserDao == userDao);
        context.close();
    }
}
