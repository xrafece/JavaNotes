package com.xrafece.service.impl;

import com.xrafece.dao.UserDao;
import com.xrafece.entity.User;
import com.xrafece.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xrafece
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean checkLogin(User user) {
        return userDao.getUserFromLogin(user) != null;
    }
}
