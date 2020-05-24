package com.lixin.core.interface_strategy;

public interface Person {

    default String playCode(String think){
        return "program";
    }
}
