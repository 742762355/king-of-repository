package com.lixin.config;


//import com.lixin.annotation.EnableAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
//@EnableAuthorization
public class AuthConfig {

    private static Logger logger=LoggerFactory.getLogger(AuthConfig.class);

    @PostConstruct
    public void init(){
        System.out.println("配置初始化!!!");
        logger.debug("配置初始化debug");
    }
}
