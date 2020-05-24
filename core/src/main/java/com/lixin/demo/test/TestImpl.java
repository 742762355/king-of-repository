package com.lixin.demo.test;

import java.util.Random;

public class TestImpl {


    public static void lockByTry(){
        Random random=new Random(10);
        if (random.nextInt()<10){
            throw new RuntimeException("xxx");
        }

        try {
            int z=2;
        }catch (Exception e){
            System.out.println(2222);
        }finally {
            System.out.println(111);
        }
    }

    public static void lockByTry1(){
        try {
            Random random=new Random(10);
            if (random.nextInt()<10){
                throw new RuntimeException("xxx");
            }
            try {
                int z=2;
            }catch (Exception e){
                System.out.println(2222);
            }finally {
                System.out.println(111);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("ddddddddddddd");
        }

    }

    public static void main(String[] args) {
        lockByTry();
    }
}
