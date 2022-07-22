package com.lixin.core.design_pattern.proxy.jdk_mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyByInvocationHandler implements InvocationHandler {

    private Object object;

    public ProxyByInvocationHandler(Object object) {
        this.object = object;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前");
        return method.invoke(object, args);
    }

    public Object getRealObj() {
        return object;
    }
}
