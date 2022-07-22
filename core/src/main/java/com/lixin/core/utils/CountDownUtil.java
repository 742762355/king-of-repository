package com.lixin.core.utils;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:lixin
 * @date:2021/1/17 20:29
 * @description: 模拟5个线程并发同时执行
 */
public class CountDownUtil {

    private static CountDownLatch latch = new CountDownLatch(1);

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void testCount() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        Thread.sleep(3000);
        latch.countDown();
    }
}
