package com.xrafece.config;

import com.xrafece.interceptor.JJWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Xrafece
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JJWTInterceptor())
                .addPathPatterns("/user/test")
                .excludePathPatterns("/user/login");
    }
}
