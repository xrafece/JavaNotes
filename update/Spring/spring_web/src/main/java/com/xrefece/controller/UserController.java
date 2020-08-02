package com.xrefece.controller;

import com.xrefece.enrty.User;
import com.xrefece.service.UserService;
import com.xrefece.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("default")
    public User getUserByDefault() {
        return userService.getUserByDefault();
    }

}
