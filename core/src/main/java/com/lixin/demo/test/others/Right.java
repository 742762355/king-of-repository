package com.lixin.demo.test.others;

/**
 * @author:lixin
 * @date:2020/4/20 8:39
 * @description: 模拟hashmap中计算向上取2进制位-1
 */
public class Right {

    int _1ln = 1;

    public static void tableSize(int size) {
        int n = size - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
    }

    public static void main(String[] args) {
        tableSize(129);
    }
}
