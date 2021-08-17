package com.lixin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.MainService;

@Controller
public class MainController {


    @Reference
    private MainService mainService;

    @Autowired
    private MainService mainService1;

    public void doSomething(){
        mainService.run();
    }
}
