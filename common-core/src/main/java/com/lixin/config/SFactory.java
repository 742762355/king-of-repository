package com.lixin.config;

public class SFactory {

    private AuthConfigProperties properties;

    public SFactory(AuthConfigProperties properties) {
        this.properties = properties;
    }

    //todo 提供可扩展方式 例如(自定义修改每个方法的配置,或者自定义处理逻辑)
}
