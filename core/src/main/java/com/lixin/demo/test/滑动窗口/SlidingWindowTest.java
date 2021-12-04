package com.lixin.demo.test.滑动窗口;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowTest {


    /**
     * @author lixin
     * @date 2021/12/3 16:41
     * @describe arr为数字数组, k为窗口的长度
     */
    @SuppressWarnings({"SameParameterValue","ConstantConditions"})
    private static int[] max(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if (list.size() == k) {
                res[i - k + 1] = Collections.max(list);
                list.removeFirst();
            }
        }
        return res;
    }

    @SuppressWarnings({"SameParameterValue","ConstantConditions"})
    private static List<int[]> fixLength(int[] arr,int windowsLength){
        List<int[]> res=new LinkedList<>();
        for (int i = 0; i < arr.length-windowsLength+1; i++) {
            int[] new1=new int[windowsLength];
            System.arraycopy(arr, i, new1, 0, windowsLength);
            res.add(new1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, -1, 22, 7, 9};
        int[] max = max(arr, 3);
        System.out.println(1);
        List<int[]> ints = fixLength(arr, 3);
        System.out.println(2);
    }
}
