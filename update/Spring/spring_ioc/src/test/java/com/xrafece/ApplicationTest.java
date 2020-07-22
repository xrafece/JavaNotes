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
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
