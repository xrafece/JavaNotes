package com.xrafece.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String HelloWorld() {
        return "Hello, SpringBoot Project start successfully.";
    }

    @RequestMapping("*")
    public String Hello() {
        return "<h1>Hello, SpringBoot Project start successfully.</h1>";
    }
}
