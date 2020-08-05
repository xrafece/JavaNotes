package com.xrafece.controller;

import com.xrafece.entry.YamlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
public class YamlController {

    @Autowired
    private YamlEntry yamlEntry;

    @GetMapping("yaml")
    public YamlEntry yamlGet() {
        System.out.println(yamlEntry);
        return yamlEntry;
    }
}
