package com.lixin.demo.test.others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Special {
    List list=new ArrayList();

    Integer[] array;



    
    /**
     * @author:lixin
     * @date:2020/4/27  15:11
     * @description: 函数式编程加stream
     */
    @Test
    public void fun(){
        List list=new LinkedList();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        Predicate<Integer> tPredicate = x -> x.intValue() > 3 && x.intValue()<90;

        Predicate<Integer> tPredicate1 = x -> x.intValue() > 0 ;

        Predicate<Object> tPredicate2 = v -> Integer.parseInt(v.toString()) > 3;
        System.out.println(list.stream().filter(tPredicate.and(tPredicate1)).collect(Collectors.toList()));
    }
}
