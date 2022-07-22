package com.lixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lixin@tongbaninfo.com
 */
@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
        System.out.println(KafkaDemoApplication.class.getSimpleName() + "启动成功!");
    }
}
