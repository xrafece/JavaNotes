package com.xrafece.config;

import com.xrafece.entry.PropertiesEntry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xrafece
 */
@Configuration
@EnableConfigurationProperties(PropertiesEntry.class)
public class PropertiesConfig {
}
