package com.lixin.demo.test;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class OOMTest {

    private ScheduledExecutorService executors=Executors.newScheduledThreadPool(10);

//    @PostConstruct
    public void init(){
        executors.schedule(new RunTask(),1,TimeUnit.SECONDS);
    }

    private static class RunTask implements Runnable{

        static int size=10000000;

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                int[] ints = new int[size];
                System.out.println(ints[i]);
            }
        }
    }
}
