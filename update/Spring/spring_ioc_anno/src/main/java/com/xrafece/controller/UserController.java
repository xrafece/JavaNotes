package com.xrafece.controller;

import com.xrafece.service.UserService;
import com.xrafece.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Xrafece
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    public void showAllUser() {
        userServiceImpl.listAllUser();
    }
}
