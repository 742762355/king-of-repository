package com.lixin.gen;

import com.lixin.service.GenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GenerateCode.class)
@MapperScan(basePackages = "com.lixin.mapper")
@ComponentScan("com.lixin")
//@EnableConfigurationProperties
public class GenerateCode {

    @Autowired
    private GenService genService;

    @Test
    public void testProperties() {
        genService.gen();
    }
}
