package com.lixin.demo.test.function_interface;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TEST {

    @Test
    public void tExtents() {
//        System.out.println(System.getProperty("user.home"));
        TestRunnable innerRunnable = new TestRunnable();
        //使用::调用,然后用接口接收表示接口实例等于这个方法,
        // 然后用接口里的方法调用就等于调用该方法
        Runnable runnable = innerRunnable::getR;
        runnable.run();

        IConvert convert = innerRunnable::getR;
        Runnable convert1 = convert.convert();
        convert1.run();
//        Runnable r = innerRunnable.getR();
//        getR.run();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
