package com.lixin.aop;

import com.lixin.annotation.RequiresPermissions;

public class RequiresPermissionsInterceptor extends AbstractAuthInterceptor {

    public RequiresPermissionsInterceptor() {
        RequiresPermissionsHandler requiresPermissionsHandler = new RequiresPermissionsHandler();
        setHandler(requiresPermissionsHandler);
        setAnnotationClass(RequiresPermissions.class);
    }
}
