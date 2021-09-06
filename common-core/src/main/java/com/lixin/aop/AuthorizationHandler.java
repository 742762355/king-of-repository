package com.lixin.aop;

import java.lang.annotation.Annotation;

public abstract class AuthorizationHandler {

    abstract void checkPermissions(Annotation invocation);
}
