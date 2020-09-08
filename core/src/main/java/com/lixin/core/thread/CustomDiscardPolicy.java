package com.lixin.core.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class CustomDiscardPolicy extends ThreadPoolExecutor.DiscardPolicy {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        super.rejectedExecution(r, e);
    }

    public CustomDiscardPolicy() {
        super();
    }
}
