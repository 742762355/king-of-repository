package com.lixin.core.interface_strategy;


import org.springframework.stereotype.Service;

@Service
public class Woman implements Person {

    @Override
    public String playCode(String think) {
        return "slow but completed";
    }
}
