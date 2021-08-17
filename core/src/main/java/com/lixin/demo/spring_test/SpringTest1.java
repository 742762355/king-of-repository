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
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootTest
@ComponentScan("com.lixin")
public class SpringTest1 {


}
