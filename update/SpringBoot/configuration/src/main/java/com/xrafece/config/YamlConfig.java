package com.xrafece.config;

import com.xrafece.entry.YamlEntry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xrafece
 */
@Configuration
@EnableConfigurationProperties(YamlEntry.class)
public class YamlConfig {
}