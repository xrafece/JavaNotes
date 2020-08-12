package com.xrafece.dao;

import com.xrafece.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Xrafece
 */
@Mapper
public interface UserDao {
    User login(User user);
}
