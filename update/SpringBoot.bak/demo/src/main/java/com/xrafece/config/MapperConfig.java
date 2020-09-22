package com.xrafece.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xrafece
 */
@Configuration
@MapperScan("com.xrafece.mapper")
public class MapperConfig {
}
