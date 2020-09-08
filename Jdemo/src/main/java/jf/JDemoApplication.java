package jf;

import com.jfinal.core.JFinal;
import com.jfinal.server.undertow.UndertowServer;
import jf.config.JConfig;
import org.springframework.boot.web.embedded.undertow.UndertowWebServer;

public class JDemoApplication {

    public static void main(String[] args) {
        UndertowServer.start(JConfig.class,8081,true);
    }
}
