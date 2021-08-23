package com.lixin.serviceImpl;

import org.apache.dubbo.config.annotation.Service;
import service.MainService;

@Service
public class MainServiceImpl implements MainService {

    public void run() {
        System.out.println("order-service");
    }
}
