package com.xrefece.service.impl;

import com.xrefece.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Xrafece
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void listAllUser() {
        System.out.println("all User.");
    }
}
