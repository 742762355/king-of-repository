package com.lixin.demo.beta;

import com.lixin.core.service.Manager;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lixin@tongbaninfo.com
 */
public class Worker {

    @Autowired
    private Manager manager;

    @PostConstruct
    public void init() {
        if (manager != null) {
            System.out.println("manage is not null");
        } else {
            System.out.println("manage not found");
        }
    }
}
