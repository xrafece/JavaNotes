package com.xrafece.dao;

import com.xrafece.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xrafece
 */
@SpringBootTest
class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    void getUserFromLogin() {
        User user = new User();
        user.setUsername("one");
        user.setPassword("test");
        User userFromLogin = userDao.getUserFromLogin(user);
        System.out.println(userFromLogin);
    }
}