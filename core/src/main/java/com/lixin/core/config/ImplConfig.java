package com.lixin.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class ImplConfig extends CommonConfig {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("ImplConfig addCorsMappings");
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义API-拦截器
        System.out.println("ImplConfig addInterceptors");
    }
}
