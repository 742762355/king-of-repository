package com.lixin.core.interface_strategy.zerenlian;

public class Handler {

    private Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void doHandle(Object object){
        System.out.println("header !!!");
        nextHandler.doHandle(object);
    }

}
