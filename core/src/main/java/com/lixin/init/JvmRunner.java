package com.lixin.init;

import java.util.List;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixin@tongbaninfo.com
 */
@Component
@RestController
public class JvmRunner {


    @GetMapping("/vm/test")
    public int init(int nums) {
        if (nums < 0 || nums > 30) {
            System.out.println("num too large or too small");
            return nums;
        }
        List<byte[]> list = Lists.newArrayList();
        for (int i = 0; i < nums; i++) {
            byte[] bytes = new byte[10 * 1024 * 1024];
            list.add(bytes);
        }
        return list.size();
    }
}
