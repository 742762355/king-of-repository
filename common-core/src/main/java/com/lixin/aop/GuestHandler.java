package com.lixin.aop;

import java.lang.annotation.Annotation;

public class GuestHandler extends AuthorizationHandler {

    @Override
    void checkPermissions(Annotation invocation) {
        System.out.println("guest request!!!");
    }
}
