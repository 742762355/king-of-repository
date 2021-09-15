package com.lixin.core.design_pattern.proxy.jdk_mode;

import com.lixin.core.design_pattern.proxy.ProxyUtil;
import org.junit.Test;

import java.lang.reflect.Field;

public class Main {


    @Test
    public void createJDKProxy(){
        ITester t = ProxyUtil.create(new Tester());
        t.printStr();
    }


    @Test
    public void getProxyH(){
        ITester t = ProxyUtil.create(new Tester());
        try {
            Field h = t.getClass().getSuperclass().getDeclaredField("h");
            h.setAccessible(true);
            Object invocationHandler = h.get(t);
            if (invocationHandler instanceof ProxyByInvocationHandler){
                Object realObj = ((ProxyByInvocationHandler) invocationHandler).getRealObj();
                System.out.println(realObj.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void createNoImpl(){
        ITester e = ProxyUtil.createE(new Tester());
        e.printStr();
    }
}
