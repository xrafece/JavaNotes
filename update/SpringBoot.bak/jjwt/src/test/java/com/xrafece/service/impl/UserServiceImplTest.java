package com.xrafece.service.impl;

import com.xrafece.entity.User;
import com.xrafece.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xrafece
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void checkLogin() {
        User user = new User();
        user.setUsername("uuu");
        user.setPassword("sss");
        System.out.println(userService.checkLogin(user));
    }
}