package com.lixin.demo.test.function_interface;

public class PrintTask implements Runnable {

    @Override
    public void run() {
        System.out.println(123);
    }
}
