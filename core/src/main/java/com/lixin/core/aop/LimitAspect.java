package com.lixin.core.aop;


import com.lixin.core.annotation.Limit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LimitAspect {


    @Pointcut("@annotation(com.lixin.core.annotation.Limit)")
    public void limit(){
    }


    @Around("limit()")
    public Object around(ProceedingJoinPoint joinPoint){
        //类
        Object target = joinPoint.getTarget();
        //方法名
        String methodName = joinPoint.getSignature().getName();
        //方法参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();

        Method method=null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Limit limit = method.getAnnotation(Limit.class);
        System.out.println("限制:"+limit.value());
        Object proceed=null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
