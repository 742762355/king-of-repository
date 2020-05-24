package com.lixin.demo.spring_test;

import com.lixin.core.interface_strategy.Person;
import com.lixin.core.service.Boss;
import com.lixin.core.service.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableAspectJAutoProxy
@SpringBootTest
@ComponentScan("com.lixin.core")
public class SpringTest {

    @Autowired
    private Worker worker;
    @Autowired
    private Boss boss;
    @Qualifier("man")
    @Autowired
    private Person person;


    /**
     * @author:lixin
     * @date:2020/5/24  23:18
     * @description: 测试简单的自定义aop
     */
    @Test
    public void testLogAop(){
        worker.doWork(1);
    }


    /**
     * @author:lixin
     * @date:2020/5/24  23:20
     * @description: 测试jdk8默认的default 关键字
     * 在工作中用某个接口的实例时不用每次都去实现一次接口的方法
     */
    @Test
    public void testDefault(){
        System.out.println(person.playCode("i want 100w"));
        System.out.println(1);
    }
}
