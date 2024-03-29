package jf.config;

import com.jfinal.config.*;
import com.jfinal.template.Engine;
import jf.controller.HelloController;

public class JConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.setBaseViewPath("src/main/resources/template");
        routes.add("/hello", HelloController.class);
    }

    @Override
    public void configEngine(Engine engine) {
    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
