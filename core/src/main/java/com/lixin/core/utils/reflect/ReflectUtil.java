package com.lixin.core.utils.reflect;

import com.lixin.core.utils.StringUtil;

import java.lang.reflect.Method;


/**
 * @author:lixin
 * @date:2020/4/20  9:15
 * @description: 反射工具类
 */
public class ReflectUtil {

    public static <T> T newInstance(String className){
        Object obj = null;
        try {
            Class cName = Class.forName(className);
            obj=cName.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }

    public static <T> T invokeMethod(Class cla,String methodName,Class<?>[] params,T... param){
        Object obj=null;
        try {
            Method method = cla.getDeclaredMethod(methodName,params);
            obj = method.invoke(cla.newInstance(), param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }

    public static void main(String[] args) {
        Class[] classes={String.class};
        Object s = ReflectUtil.invokeMethod(StringUtil.class, "isMatch",classes, "com");
        System.out.println(s);
    }
}
