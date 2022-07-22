package com.lixin.demo.test.function_interface;

public class TestRunnable<T> {

    public Runnable getR() {
        System.out.println("xxx");
        return new PrintTask();
    }
}
