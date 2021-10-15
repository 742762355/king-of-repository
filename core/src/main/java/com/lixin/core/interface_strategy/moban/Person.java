package com.lixin.core.interface_strategy.moban;

public interface Person {

    default String playCode(String think){
        return "program";
    }
}
