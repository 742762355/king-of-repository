package com.lixin.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CommonConfig implements WebMvcConfigurer {

    private static String[] excludePaths={
            "/module/update/reform",
            "/module/test/redis",
    };


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CommonConfig addCorsMappings");
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义API-拦截器
        System.out.println("CommonConfig addInterceptors");
    }
}
