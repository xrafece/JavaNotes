package com.xrafece.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Xrafece
 */
//表示这是一个 Spring JavaConfig 类
@Configuration
//需要扫描注解的基本包路径，多个路径可以用数组表示或者使用 @ComponentScans 注解
@ComponentScan("com.xrafece")
//导入另外一个配置类
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
