package com.xrafece.service.impl;

import com.xrafece.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Xrafece
 */
@Service
public class UserServiceImpl implements UserService {
    public void listAllUser() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("User1: {name = Tom, address = cat}, \nUser2: {name = Cat, address = tom}");
    }

    public void getUser() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("User9: {name = Tom, address = cat}");
    }

    public void addUserError() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("add User2: {name = Cat, address = tom}");
        int i = 1/0;
        System.out.println("add success");
    }
}