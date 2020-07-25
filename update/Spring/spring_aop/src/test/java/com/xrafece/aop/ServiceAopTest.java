package com.xrafece.aop;

import com.xrafece.service.AccountService;
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
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceAopTest {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;


    @Test
    public void testListAllUser() throws InterruptedException {
        userService.listAllUser();
    }

    @Test
    public void testListAllAccount() throws InterruptedException {
        accountService.listAllAccount();
    }

    @Test
    public void testAddUserError() throws InterruptedException {
        userService.addUserError();
    }

    @Test
    public void testGetUser() throws InterruptedException {
        userService.getUser();
    }

    // @Autowired
    // private UserServiceImpl userServiceImpl;
    // @Test
    // public void proxyInstanceTypeTest() {
    //     userServiceImpl.listAllUser();
    // }
    // RunTime Error
    // nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException:
    // Bean named 'userService' is expected to be of type 'com.xrafece.service.impl.UserServiceImpl' but was actually of type 'com.sun.proxy.$Proxy15'
    // 原因，当被增强的方法所在的类是接口实现类，也就是有接口时，代理实现方式是 JDK 方式实现动态代理，
    // 代理对象和目标对象都是接口实现类，所以如果我们的被增强方法有接口时，调用增强后方法要使用接口调用。
}
