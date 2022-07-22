package jf;

import com.jfinal.server.undertow.UndertowServer;
import jf.config.JConfig;

public class JDemoApplication {

    public static void main(String[] args) {
        UndertowServer.start(JConfig.class, 8081, true);
    }
}
