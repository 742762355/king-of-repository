package com.lixin.demo.test;

import com.lixin.demo.test.function_interface.IConvert;
import com.lixin.demo.test.function_interface.TestRunnable;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestImpl {


    public static void lockByTry() {
        Random random = new Random(10);
        if (random.nextInt() < 10) {
            throw new RuntimeException("xxx");
        }

        try {
            int z = 2;
        } catch (Exception e) {
            System.out.println(2222);
        } finally {
            System.out.println(111);
        }
    }

    public static void lockByTry1() {
        try {
            Random random = new Random(10);
            if (random.nextInt() < 10) {
                throw new RuntimeException("xxx");
            }
            try {
                int z = 2;
            } catch (Exception e) {
                System.out.println(2222);
            } finally {
                System.out.println(111);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ddddddddddddd");
        }

    }

    public static void main(String[] args) {
        lockByTry();
    }


    @Test
    public void test() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
