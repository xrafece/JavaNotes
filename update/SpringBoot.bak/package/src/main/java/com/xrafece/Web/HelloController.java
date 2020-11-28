package com.xrafece.Web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
public class HelloController {
    @GetMapping
    public String HelloWorld(){
        return "hello world";
    }
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
