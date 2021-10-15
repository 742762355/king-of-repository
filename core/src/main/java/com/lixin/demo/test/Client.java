package com.lixin.demo.test;

import javax.websocket.*;

@ClientEndpoint
public class Client{
    @OnOpen
    public void onOpen(Session session) {

        System.out.println(11);
    }
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client onMessage: " + message);
    }
    @OnClose
    public void onClose() {}
}
