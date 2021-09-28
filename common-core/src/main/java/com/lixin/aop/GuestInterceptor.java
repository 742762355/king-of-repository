package com.lixin.aop;

import com.lixin.annotation.Guest;

public class GuestInterceptor extends AbstractAuthInterceptor {

    public GuestInterceptor() {
        GuestHandler guestHandler = new GuestHandler();
        setHandler(guestHandler);
        setAnnotationClass(Guest.class);
    }
}
