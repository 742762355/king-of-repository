package com.lixin.demo.test.work;

import org.junit.Test;

public class BugNumberOutUtil {


    @Test
    public void out(){
        Integer[] bugIds={37224};

        for (int i = 0; i < bugIds.length; i++) {
            if (i==bugIds.length-1) {
                System.out.print("【"+bugIds[i]+"】");
                continue;
            }
            System.out.print("【"+bugIds[i]+"】,");
        }
    }
}
