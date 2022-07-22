package com.lixin.demo.test.javaagent;

import java.lang.instrument.Instrumentation;

public class PreMain {

    public static void premain(String agentOps) {
        System.out.println("premain 2");
    }

    public static void premain(String agentOps, Instrumentation instrumentation) {
        System.out.println("premain 1");
    }
}
