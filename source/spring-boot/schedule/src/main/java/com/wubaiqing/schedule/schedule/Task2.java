package com.wubaiqing.schedule.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Task2 {

    private static final SimpleDateFormat dateFormmat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    private void process() {
        System.out.println("current time" + dateFormmat.format(new Date()));
    }
}
