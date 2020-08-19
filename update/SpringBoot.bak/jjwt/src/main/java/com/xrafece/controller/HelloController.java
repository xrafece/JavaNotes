package com.xrafece.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String helloWorld() {
        return "hello world";
    }

}
