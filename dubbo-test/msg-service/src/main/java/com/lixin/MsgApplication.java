package com.lixin;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.lixin")
public class MsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgApplication.class, args);
        System.out.println("msg-server启动成功");
    }
}
