package com.lixin.core.interface_strategy;


import org.springframework.stereotype.Service;

@Service
public class Man implements Person {


    @Override
    public String playCode(String think) {
        return "fast but not perfect";
    }
}
