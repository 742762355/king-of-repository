package com.lixin.core.etcd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EtcdOperatorTest {

    @Autowired
    private EtcdOperator operator;

    @Test
    public void testPutAndGet() {
        operator.put("1", "123");
        String result = operator.get("1");
        Assert.assertEquals("123", result);
    }

}