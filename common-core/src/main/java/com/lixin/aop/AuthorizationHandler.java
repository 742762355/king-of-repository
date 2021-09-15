package com.lixin.aop;

import java.lang.annotation.Annotation;

abstract class AuthorizationHandler {

    abstract void checkPermissions(Annotation invocation);
}
