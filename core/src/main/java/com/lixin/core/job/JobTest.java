package com.lixin.core.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobTest {


    @Scheduled(cron = "0 */10 * * * ?")
    public void execute(){
        System.out.println("当前时间:"+System.currentTimeMillis()/1000);
    }
}
