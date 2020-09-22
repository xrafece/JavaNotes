package com.xrafece.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("a")
    public String helloWorld() {
        return "Hello World";
    }
}
