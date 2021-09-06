package com.lixin.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther     lixin
 * @date       2021/9/6 10:52
 * @describe   一个做转发的类
 */
public class AopAuthorizationInterceptor implements MethodInterceptor {

    private List<AbstractAuthInterceptor> annotationMethodInterceptors=new ArrayList<>();

    public AopAuthorizationInterceptor() {
        annotationMethodInterceptors.add(new RequiresPermissionsInterceptor());
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
