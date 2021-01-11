package com.lixin.demo.test;

import org.junit.Test;

public class Undefine {

    @Test
    public void test(){
        m1();
    }

    private void m1() {
        try {
            int i = m2();
            System.out.println(i);
        }catch (Exception e){
            System.out.println("m2-catch-error");
            e.printStackTrace();
        }
        System.out.println(2);
        System.out.println(3);
    }

    private int m2() {
        try {
            int i = 1/0;
            return 1;
        }catch (Exception e){
            System.out.println("m2-error");
            e.printStackTrace();
        }finally {
            int a=2;
            return 2;
//            System.out.println(1);
        }

    }
}
