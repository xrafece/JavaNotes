package com.xrafece.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xrafece
 */
@Controller
public class UserController {
    @ResponseBody
    @RequestMapping("hello")
    public String helloWorld() {
        return "hello";
    }
}
