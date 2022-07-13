package com.lixin.controller;

import com.lixin.core.config.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

@RequestMapping("ws")
@RestController
public class WSSenderController {

    private static Session session;

    private static final String domain1="lixin.module.com:8070";

    private static final String domain2="msapi.modo2.cn";

    private static final String domain3="47.52.143.190:9090";

    private static final String domain4="192.168.13.75:8080";

    //正式
    private static final String domain5="msapi.modo.cn";

    private static final String domain6="121.40.68.129:80";

    private static final String wsUrl="ws://"+domain6+"/notice/websocket/466";

//    {
//        link();
//    }

    public static void link(){
        try {
             WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
             URI uri = URI.create(wsUrl);
            session=webSocketContainer.connectToServer(Client.class,uri);
            System.out.println("websocket link!!!");
        } catch (DeploymentException | IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("send")
    public void send(){
        try {
            session.getBasicRemote().sendText("www");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
