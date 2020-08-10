package com.xrafece.controller;

import com.xrafece.entry.YamlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xrafece
 */
@RestController
// @EnableConfigurationProperties(YamlEntry.class)
public class YamlController {

    // idea 报错，无法自动装配 bean ，但是并不影响使用
    @Autowired
    private YamlEntry yamlEntry;

    @GetMapping("yaml")
    public YamlEntry getRequestYaml() {
        System.out.println(yamlEntry);
        return yamlEntry;
    }
}
