package com.xrefece.service;

import com.xrefece.enrty.User;

/**
 * @author Xrafece
 */
public interface UserService {
    void listAllUser();

    /**
     * 获取默认用户
     *
     * @return 默认用户
     */
    User getUserByDefault();
}
