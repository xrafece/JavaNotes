package com.xrafece.dao;

import com.xrafece.entity.User;

/**
 * @author Xrafece
 */
public interface UserDao {
    User getUserFromLogin(User user);
}
