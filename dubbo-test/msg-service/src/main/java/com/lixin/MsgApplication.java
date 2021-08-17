package com.lixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lixin")
public class MsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgApplication.class,args);
        System.out.println("msg-server启动成功");
    }
}
