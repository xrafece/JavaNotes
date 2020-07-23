package com.xrafece.dao.impl;

import com.xrafece.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Xrafece
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void listAllUser() {
        System.out.println("Analog output for all users.");
    }
}
