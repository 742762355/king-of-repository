package com.lixin.core.design_pattern.proxy.cglib_mode;

import com.lixin.core.design_pattern.proxy.ProxyUtil;
import org.junit.Test;

public class Main {
    
    
    @Test
    public void createByCglib(){
        TTT byCglib = ProxyUtil.createByCglib(new TTT());
        byCglib.print();
    }
}
