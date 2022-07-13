package com.lixin.config;


//import com.lixin.annotation.EnableAuthorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
//@EnableAuthorization
public class AuthConfig {

    @Value("${appId}")
    private String appId;

    private static Logger logger = LoggerFactory.getLogger(AuthConfig.class);

    @PostConstruct
    public void init() {
        System.out.println("配置初始化!!!"+appId);
        logger.debug("配置初始化debug");
    }
}
