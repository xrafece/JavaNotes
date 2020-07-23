package com.xrafece.service.impl;

import com.xrafece.dao.UserDao;
import com.xrafece.dao.impl.UserDaoImpl;
import com.xrafece.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xrafece
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public void listAllUser() {
        userDaoImpl.listAllUser();
    }
}
