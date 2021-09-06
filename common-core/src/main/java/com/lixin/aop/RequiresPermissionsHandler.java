package com.lixin.aop;

import java.lang.annotation.Annotation;

public class RequiresPermissionsHandler extends AuthorizationHandler {


    @Override
    void checkPermissions(Annotation invocation) {
        //1. 校验注解和拿到值
        //2. 发送请求去验证
        System.out.println("requiresPermissions");
        System.out.println("发送请求去验证!!!");
    }
}
