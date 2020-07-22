package com.xrafece.dao;

import com.xrafece.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xrafece
 */
public class UserDaoTest {
    @Test
    public void testInitSpringIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("IOC container is initialized.");
        // 测试默认无参构造方法创建 bean
        UserDao userDao = context.getBean("userDao", UserDaoImpl.class);
        userDao.saveUser();
        System.out.println("---------------------");
        //静态工厂
        UserDao userDaoStatic = context.getBean("userDaoStatic", UserDao.class);
        userDaoStatic.saveUser();
        System.out.println("---------------------");
        //实例工厂
        UserDao userDaoDynamic = context.getBean("userDaoDynamic", UserDao.class);
        userDaoDynamic.saveUser();
        System.out.println("---------------------");

        //单例对象
        UserDao userDaoSingleton01 = context.getBean("userDaoSingleton", UserDao.class);
        UserDao userDaoSingleton02 = context.getBean("userDaoSingleton", UserDao.class);
        System.out.println(userDaoSingleton01 == userDaoSingleton02);
        System.out.println(userDaoSingleton01.hashCode()+"``````````"+userDaoSingleton02.hashCode());
        System.out.println("---------------------");
        // 多例对象
        UserDao userDaoPrototype01 = context.getBean("userDaoPrototype", UserDao.class);
        UserDao userDaoPrototype02 = context.getBean("userDaoPrototype", UserDao.class);
        System.out.println(userDaoPrototype01 == userDaoPrototype02);
        System.out.println(userDaoPrototype01.hashCode()+"``````````"+userDaoPrototype02.hashCode());
        System.out.println("---------------------");
        // 生命周期
        UserDao userDaoLifeCycle = context.getBean("userDaoLifeCycle", UserDao.class);
        userDaoLifeCycle.saveUser();
        System.out.println("---------------------");
        //关闭容器，验证生命周期的销毁方法
        context.close();

        //注： 并不能使用同一个类同时验证，需要注释一部分

    }
}
