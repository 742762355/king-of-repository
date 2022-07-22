package com.lixin.demo.test.others;

import com.lixin.core.domain.User;
import com.lixin.core.interface_strategy.moban.Man;
import com.lixin.demo.test.function_interface.IConvert;
import com.lixin.demo.test.function_interface.TestRunnable;
//import lombok.var;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
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


    @Test
    public void soutTest() {
//        System.out.println(null+"0");
        List<String> a = new LinkedList<>();
        a.add("11");
        a.add("22");
        a.add("33");
        a.add("44");
        List<String> strings = a.subList(0, 1);
        System.out.println(1);

    }

}
