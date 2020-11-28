package com.xrafece.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xrafece
 */
@Controller
@RequestMapping("yiban")
public class YiBanController {
    public String bindYiBanInfo(){
        return "oon";
    }
}
