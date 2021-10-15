package com.lixin.demo.spring_test;

import org.junit.runner.RunWith;
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
