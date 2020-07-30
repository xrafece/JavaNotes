package com.xrefece.service.impl;

import com.xrefece.dao.UserDao;
import com.xrefece.dao.impl.UserDaoImpl;
import com.xrefece.service.UserService;
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
    public void listAllUser() {
        System.out.println("all User.");
    }
}
