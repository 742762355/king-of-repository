package com.lixin.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import service.MainService;

@Service
public class MainServiceImpl implements MainService {

    public void run() {
        System.out.println("msg-service");
    }
}
