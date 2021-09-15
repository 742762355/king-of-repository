package com.lixin.aop;

import com.lixin.annotation.RequiresPermissions;

class RequiresPermissionsInterceptor extends AbstractAuthInterceptor {

    RequiresPermissionsInterceptor() {
        RequiresPermissionsHandler requiresPermissionsHandler = new RequiresPermissionsHandler();
        setHandler(requiresPermissionsHandler);
        setAnnotationClass(RequiresPermissions.class);
    }
}
