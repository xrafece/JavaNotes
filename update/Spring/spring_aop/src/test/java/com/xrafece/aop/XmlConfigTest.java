package com.xrafece.aop;

import com.xrafece.config.SpringConfig;
import com.xrafece.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Xrafece
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext_aop.xml")
public class XmlConfigTest {

    @Autowired
    private UserService userService;

    @Test
    public void name() throws InterruptedException {
        userService.listAllUser();
    }
}
