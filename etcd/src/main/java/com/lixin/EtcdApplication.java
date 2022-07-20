package com.lixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lixin@tongbaninfo.com
 */
@SpringBootApplication
public class EtcdApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtcdApplication.class, args);
        System.out.println(EtcdApplication.class.getSimpleName() + "启动成功");
    }
}
