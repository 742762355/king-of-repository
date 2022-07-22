package com.lixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lixin@tongbaninfo.com
 */
@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
        System.out.println(MongoApplication.class.getSimpleName() + "启动成功!");
    }
}
