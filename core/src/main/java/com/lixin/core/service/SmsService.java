package com.lixin.core.service;

import com.lixin.core.annotation.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

//    @Autowired
//    private SmsService smsService;

    @Async
    public void T1() {
        System.out.println("thread-1");
        logger.info("thread-1");
    }

    @Async
    public void T2() {
        System.out.println("thread-2");
        logger.info("thread-2");
    }

    @Log
    public void f1() {
        System.out.println("执行了f1方法");
        f2();
    }

    @Log
    public void f2() {
        System.out.println("执行了f2方法");
        ((SmsService) AopContext.currentProxy()).f3();
    }

    @Log
    public void f3() {
        System.out.println("执行了f3方法");
    }
}
