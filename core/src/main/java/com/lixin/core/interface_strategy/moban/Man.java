package com.lixin.core.interface_strategy.moban;


import org.springframework.stereotype.Service;

@Service
public class Man implements Person, Human {


    @Override
    public String playCode(String think) {
        return "fast but not perfect";
    }
}
