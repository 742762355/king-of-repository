package com.lixin.aop;

import java.util.ArrayList;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author lixin
 * @date 2021/9/6 10:52
 * @describe 一个做转发的类
 */
public class AopAuthorizationInterceptor implements MethodInterceptor {

    private final List<AbstractAuthInterceptor> annotationMethodInterceptors = new ArrayList<>();

    public AopAuthorizationInterceptor() {
        annotationMethodInterceptors.add(new RequiresPermissionsInterceptor());
        annotationMethodInterceptors.add(new GuestInterceptor());
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //各自注解的handler做验证
        checkPermissions(invocation);
        return invocation.proceed();
    }

    private void checkPermissions(MethodInvocation invocation) {
        for (AbstractAuthInterceptor methodInterceptor : annotationMethodInterceptors) {
            methodInterceptor.getHandler().checkPermissions(methodInterceptor.getAnnotation(invocation));
        }
    }
}
