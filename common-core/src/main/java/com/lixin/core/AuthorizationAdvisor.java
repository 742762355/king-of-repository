package com.lixin.core;

import com.lixin.annotation.RequiresPermissions;
import com.lixin.aop.AopAuthorizationInterceptor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AuthorizationAdvisor extends StaticMethodMatcherPointcutAdvisor {

    private Class[] MATCH_ANNOTATIONS={
            RequiresPermissions.class
    };

    public AuthorizationAdvisor(){
        setAdvice(new AopAuthorizationInterceptor());
    }


    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        for (Class annClass : MATCH_ANNOTATIONS) {
            Annotation annotation = AnnotationUtils.findAnnotation(method, annClass);
            if (annotation!=null)return true;
        }
        return false;
    }
}
