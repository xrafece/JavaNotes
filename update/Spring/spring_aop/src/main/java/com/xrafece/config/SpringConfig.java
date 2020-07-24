package com.xrafece.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Xrafece
 */

@Configuration
@ComponentScan("com.xrafece")
@Import(AopConfig.class)
public class SpringConfig {
}
