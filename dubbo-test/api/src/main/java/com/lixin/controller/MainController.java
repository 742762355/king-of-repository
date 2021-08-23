package com.lixin.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MainService;

@RestController
public class MainController {


    @Reference
    private MainService mainService;

    @Autowired
    private MainService mainService1;

    @GetMapping("/t")
    public void doSomething(){
        mainService.run();
    }

    @GetMapping("/t1")
    public void doSomething1(){
        mainService1.run();
    }
}
