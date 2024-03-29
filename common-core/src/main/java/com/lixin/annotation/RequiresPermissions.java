package com.lixin.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermissions {

    String[] value();
}
