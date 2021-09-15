package com.lixin.aop;

import com.lixin.annotation.RequiresPermissions;

import java.lang.annotation.Annotation;

class RequiresPermissionsHandler extends AuthorizationHandler {


    @Override
    void checkPermissions(Annotation invocation) {
        if (!(invocation instanceof RequiresPermissions))return;
        RequiresPermissions annotation = (RequiresPermissions) invocation;
        String[] value = annotation.value();

        //1. 校验注解和拿到值
        //2. 发送请求去验证
        System.out.println("requiresPermissions");
        System.out.println("发送请求去验证!!!");
    }
}
