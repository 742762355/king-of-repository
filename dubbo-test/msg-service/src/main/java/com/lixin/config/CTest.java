package com.lixin.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CTest {


    @PostConstruct
    public void init(){
        System.out.println("ctest初始化。。。。。。。");
    }
}
