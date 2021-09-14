package com.lixin.core.design_pattern.wait;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class CountDownObject {

    private static final CountDownLatch countDownLatch=new CountDownLatch(5);

//    private static List joinedList=new LinkedList();

    private static boolean isFull=false;


    private static class JoinWorker implements Runnable{

        String joinId;

        JoinWorker(String joinId){
            this.joinId=joinId;
        }

        @Override
        public void run(){
            if (!isFull){
//                joinedList.add(joinId);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(joinId);
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
            }
        }
    }

    @Test
    public void mainThread(){
        System.out.println("主线程准备--并等待其他5人加入");
        for (int i = 0; i < 5; i++) {
            new Thread(new JoinWorker("the "+(i+1)+" person")).run();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isFull=true;
        System.out.println("主线程执行完成了");
    }

    /**
     * @author:lixin
     * @date:2020/5/20  10:57
     * @description: 假设5个人加入房间,5个人都加入了才执行操作
     */
//    public void join(String joinId){
//        if (!isFull){
//            joinedList.add(joinId);
////            if (countDownLatch.getCount()==0){
//                countDownLatch.countDown();
//                try {
//                    countDownLatch.await();
//                    System.out.println("count-1:"+countDownLatch.getCount());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
////            }
//            System.out.println("xxx");
//        }
//
//    }


//    @Test
//    public void join1(){
//        //每次新加一个人就是一个单独的线程
//        JoinWorker joinWorker1=new JoinWorker("the first person");
//        Thread task=new Thread(joinWorker1);
//        task.run();
//    }
//
//    @Test
//    public void join2(){
//        JoinWorker joinWorker1=new JoinWorker("the two person");
//        new Thread(joinWorker1).run();
//    }
//
//    @Test
//    public void join3(){
//        JoinWorker joinWorker1=new JoinWorker("the three person");
//        new Thread(joinWorker1).run();
//    }
//
//    @Test
//    public void join4(){
//        JoinWorker joinWorker1=new JoinWorker("the four person");
//        new Thread(joinWorker1).run();
//    }
//
//    @Test
//    public void join5(){
//        JoinWorker joinWorker1=new JoinWorker("the five person");
//        new Thread(joinWorker1).run();
//    }
//
//    @Test
//    public void join6(){
//        JoinWorker joinWorker1=new JoinWorker("the 6 person");
//        new Thread(joinWorker1).run();
//    }
}

class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行…… ……");
        //第一个子线程执行
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es1.shutdown();

        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
    }
}
