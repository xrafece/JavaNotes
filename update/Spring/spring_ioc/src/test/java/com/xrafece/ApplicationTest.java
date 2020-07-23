package com.xrafece;

import com.xrafece.entry.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xrafece
 */
public class ApplicationTest {
    @Test
    public void springDITest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = applicationContext.getBean("user01", User.class);
        User user2 = applicationContext.getBean("user02", User.class);
        System.out.println("-------------------分割线-------------------");
        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);
    }
}
