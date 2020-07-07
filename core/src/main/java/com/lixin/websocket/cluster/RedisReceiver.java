package com.lixin.websocket.cluster;

import org.springframework.stereotype.Component;

@Component
public interface RedisReceiver {

    public void receiveMessage(String message);
}
