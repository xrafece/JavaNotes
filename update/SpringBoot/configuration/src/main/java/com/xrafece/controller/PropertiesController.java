package com.xrafece.controller;

import com.xrafece.entry.PropertiesEntry;
import com.xrafece.entry.YamlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;;

/**
 * @author Xrafece
 */
@RestController
// @EnableConfigurationProperties(PropertiesEntry.class)
public class PropertiesController {

    // idea 报错，无法自动装配 bean ，但是并不影响使用
    // 因为不是在配置类中添加 @EnableConfigurationProperties 注解，所以 idea 无法从 spring 上下文其中得知
    @Autowired
    private PropertiesEntry propertiesEntry;

    @GetMapping("properties")
    public PropertiesEntry getRequestYaml() {
        System.out.println(propertiesEntry);
        return propertiesEntry;
    }
}
