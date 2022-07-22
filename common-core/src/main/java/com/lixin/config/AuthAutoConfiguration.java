package com.lixin.config;

import com.lixin.core.AuthorizationAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "modo.user.enabled", matchIfMissing = true)
public class AuthAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public AuthorizationAdvisor getHandler() {
        return new AuthorizationAdvisor();
    }


}
