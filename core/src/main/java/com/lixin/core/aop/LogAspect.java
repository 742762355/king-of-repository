package com.lixin.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.lixin.core.annotation.Log)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceed) {
        Object result = null;
        try {
            System.out.println("日志切面前");
            result = proceed.proceed();
            System.out.println("日志切面后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
