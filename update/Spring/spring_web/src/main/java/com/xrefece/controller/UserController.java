package com.xrefece.controller;

import com.xrefece.service.UserService;
import com.xrefece.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xrafece
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("a")
    public String helloWorld() {
        System.out.println("sss");
        userService.listAllUser();
        return "hello";
    }
}
