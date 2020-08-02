package com.xrefece.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xrafece
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String helloWorld() {
        System.out.println("Hello World!");
        return "Hello, SpringMVC application success!";
    }
    @ResponseBody
    @RequestMapping("{name}")
    public String helloWorld(@PathVariable("name")String name) {
        System.out.println("Hello World!");
        return name;
    }
}
