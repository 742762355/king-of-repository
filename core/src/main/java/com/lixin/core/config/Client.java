package com.lixin.core.config;

import com.lixin.controller.WSSenderController;

import javax.websocket.*;

@ClientEndpoint
public class Client {
    @OnOpen
    public void onOpen(Session session) {

        System.out.println(11);
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client onMessage: " + message);
    }

    @OnClose
    public void onClose() throws Exception {
        System.out.println("client close");
        Thread.sleep(5000);
        WSSenderController.link();
    }

    @OnError
    public void OnError(Throwable throwable) {
        System.out.println("client error");
    }
}
