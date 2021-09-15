package com.lixin.config;


import com.lixin.annotation.EnableAuthorization;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableAuthorization
public class AuthConfig {


    @PostConstruct
    public void init(){
        System.out.println("配置初始化!!!");
    }
}
