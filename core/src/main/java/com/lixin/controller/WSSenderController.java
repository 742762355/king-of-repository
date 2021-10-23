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

    {
        link();
    }

    public static void link(){
        try {
             WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
             URI uri = URI.create("ws://localhost:8070/notice/websocket/466");
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
