package com.lixin.demo.test.work;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BugNumberOutUtil {


    @Test
    public void out(){
        Integer[] bugIds={37493};
        String out="";
        for (int i = 0; i < bugIds.length; i++) {
            if (i==bugIds.length-1) {
                Integer s=bugIds[i];
//                System.out.print("\""+s+"\""+",");
//                continue;

            }
            System.out.print("\"+bugIds[i].trim()+\",");
        }
    }

    @Test
    public void testDate(){
        String start="08:33";
        String end="08:30";
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:ss");
        Date d1=null;
        Date d2=null;
        try {
            d1=dateFormat.parse(start);
            d2=dateFormat.parse(end);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(d1.compareTo(d2));
    }

    @Test
    public void test(){
        if (1==1){
            throw new RuntimeException();
        }
        try {
            System.out.println("处理异常");
        }catch (Exception e){
            System.out.println("异常了");
        }finally {
            System.out.println(123456);
        }
    }

    @Test
    public void testCatch(){
        System.out.println(saveLog());
    }

    public String methodInvoke(){
        return "12345678xx";
    }

    public String saveLog(){
        String s = methodInvoke();
        try {
            if (1==1)throw new Exception("发生错误了!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return s;
        }
    }


    @Test
    public void testThrowable(){
        System.out.println(thr());
    }

    public String thr(){
        try {
            int i=1/0;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("123fail");
        }
        return "1234";
    }
}
