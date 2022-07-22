package com.lixin.util;

import org.apache.velocity.app.Velocity;

import java.util.Properties;

public class VelocityInitializer {

    public static void initVelocity() {
        try {
            Properties p = new Properties();
            p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

            p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
            p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
            Velocity.init(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
