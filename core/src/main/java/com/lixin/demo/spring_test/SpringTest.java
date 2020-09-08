package com.lixin.demo.spring_test;

import com.lixin.core.interface_strategy.Person;
import com.lixin.core.service.Boss;
import com.lixin.core.service.SmsService;
import com.lixin.core.service.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootTest
@ComponentScan("com.lixin")
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
}
