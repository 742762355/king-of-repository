package com.lixin.core.design_pattern.proxy;

import com.lixin.core.design_pattern.proxy.jdk_mode.ProxyByInvocationHandler;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

public class ProxyUtil {


    @SuppressWarnings("unchecked")
    public static <T> T create(Object obj) {
        Object proxyInstance = new ProxyByInvocationHandler(obj).newInstance();
        return (T) proxyInstance;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createE(Object obj) {
        //(proxy, method, args) ->method.invoke(tester,args)  创建匿名实现;
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("111111");
            return method.invoke(obj, args);
        });
    }

    @SuppressWarnings("unchecked")
    public static <T> T createByCglib(Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {

            System.out.println("222");
            method.setAccessible(true);
            return method.invoke(object, args);
        });
        return (T) enhancer.create();
    }
}
