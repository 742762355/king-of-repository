package com.lixin.core.service;


import com.lixin.core.annotation.Limit;
import com.lixin.core.annotation.Log;
import org.springframework.stereotype.Component;

@Component
public class Worker {


    @Log
    @Limit("12")
    public void doWork(Integer i){
        System.out.println(i.hashCode());
    }
}
