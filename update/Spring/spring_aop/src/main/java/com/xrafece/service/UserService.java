package com.xrafece.service;

/**
 * @author Xrafece
 */
public interface UserService {
    /**
     * 获取所有 User 列表
     */
    void listAllUser() throws InterruptedException;

    void getUser() throws InterruptedException;

    void addUserError() throws InterruptedException;
}
