package com.lixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lixin.mapper")
public class GenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
        System.out.println("generate 项目启动成功");
    }
}
