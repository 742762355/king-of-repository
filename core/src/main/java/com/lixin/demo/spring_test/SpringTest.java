package com.lixin.demo.spring_test;

import com.lixin.core.interface_strategy.moban.Person;
import com.lixin.core.service.Boss;
import com.lixin.core.service.SmsService;
import com.lixin.core.service.UserService;
import com.lixin.core.service.Worker;
import com.lixin.core.config.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.websocket.*;
import java.io.InputStream;
import java.net.URI;

@RunWith(SpringRunner.class)
//@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan("com.lixin")
@MapperScan("com.lixin")
public class SpringTest {

    @Autowired
    private Worker worker;
    @Autowired
    private Boss boss;
    @Qualifier("man")
    @Autowired
    private Person person;
    @Autowired
    private SmsService smsService;
    @Autowired
    private UserService userService;

    /**
     * @author:lixin
     * @date:2020/5/24  23:18
     * @description: ???????????aop
     */
    @Test
    public void testLogAop(){
        worker.doWork(1);
    }


    /**
     * @author:lixin
     * @date:2020/5/24  23:20
     * @description: ????jdk8????default ?????
     * ??????????????????????????ζ???????ν??????
     */
    @Test
    public void testDefault(){
        System.out.println(person.playCode("i want 100w"));
        System.out.println(1);
    }


    @Test
    public void async(){
        smsService.T1();
        smsService.T2();
    }

    @Test
    public void testTranction(){
        smsService.f1();
    }

    @Test
    public void testDecode(){

    }

    @Test
    public void testTran(){
        userService.trans();
    }


    @Test
    public void linkWebSocket() throws Throwable{
        String wsUri="ws://localhost:8070/notice/websocket/466";
        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
        Session session=null;
        URI uri = URI.create(wsUri);
        session=webSocketContainer.connectToServer(Client.class,uri);
        session.getBasicRemote().sendText("www");
        InputStream in = System.in;
        while (in.read()>1){
            System.out.println(1);
        }
    }
}
