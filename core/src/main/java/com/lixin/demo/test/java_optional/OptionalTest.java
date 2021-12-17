package com.lixin.demo.test.java_optional;

import org.junit.Test;

import java.util.Optional;
import java.util.Random;

/**
 * @author lixin
 * @date 2021/12/10 15:00
 * @describe 测试java中的optional API
 */
public class OptionalTest {

    @Test
    public void optionalNull() {
        Random random = new Random();
        int i = random.nextInt(5);
        Boolean object = i % 2 == 1 ? null : i > 2 ;
        Optional<Boolean> object1 = Optional.ofNullable(object);
        object1.ifPresent(a -> object1.get());
        System.out.println(Optional.ofNullable(object).isPresent());
        Optional<Boolean> object2 = Optional.ofNullable(object);
    }

    public Boolean presentOut(Optional<Boolean> optional){
        return optional.orElse(false);
    }
}
