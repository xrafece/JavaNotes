package com.xrefece.dao.impl;

import com.xrefece.dao.UserDao;
import com.xrefece.enrty.User;
import org.springframework.stereotype.Repository;

/**
 * @author Xrafece
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByDefault() {
        User user = new User();
        user.setName("Xrafece");
        return user;
    }
}
