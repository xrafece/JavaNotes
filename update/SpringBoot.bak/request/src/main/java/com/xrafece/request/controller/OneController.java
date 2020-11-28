package com.xrafece.request.controller;

import com.xrafece.request.entity.One;
import org.springframework.web.bind.annotation.*;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("one")
public class OneController {

    @GetMapping("t")
    public One getOne(One one) {
        return one;
    }
    @PostMapping("t")
    public One postOne(@RequestBody One one) {
        return one;
    }
}
