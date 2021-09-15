package com.lixin.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.annotation.Annotation;

abstract class AbstractAuthInterceptor {

    private AuthorizationHandler handler;

    private Class<? extends Annotation> annotationClass;

    public AuthorizationHandler getHandler() {
        return handler;
    }

    public void setHandler(AuthorizationHandler handler) {
        this.handler = handler;
    }

    public Class<? extends Annotation> getAnnotationClass() {
        return annotationClass;
    }

    public void setAnnotationClass(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public Annotation getAnnotation(MethodInvocation methodInvocation){
        return methodInvocation.getMethod().getAnnotation(getAnnotationClass());
    }
}
