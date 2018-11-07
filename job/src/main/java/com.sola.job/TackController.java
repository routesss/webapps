package com.sola.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TackController {

    //@Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
    public void taskA(){
        System.out.println("taskA");
    }

}
