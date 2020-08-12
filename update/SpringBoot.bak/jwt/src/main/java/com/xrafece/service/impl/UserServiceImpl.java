package com.xrafece.service.impl;

import com.xrafece.dao.UserDao;
import com.xrafece.entity.User;
import com.xrafece.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Xrafece
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User u = userDao.login(user);
        if (u != null) {
            return u;
        }
        throw new RuntimeException("密码错误.登陆失败.");
    }
}
