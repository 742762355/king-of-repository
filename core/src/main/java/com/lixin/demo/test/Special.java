package com.lixin.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Special {
    List list=new ArrayList();

    Integer[] array;

    //java不能
//    public void and(){
//        if (array&&array[0]&&array[0].equals(2)){}
//    }


    //vue写法能这样写
    //var list=[];
    //if(this.list&&this.list[0]){ ...}
    //页面展示如果没值或者取不到对象的属性  不让页面报错  也不使用v-if
    //{{list[0]&&list[0].name}}  or   {{item&&item.name}}


    
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
