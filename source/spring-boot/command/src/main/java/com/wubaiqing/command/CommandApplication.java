package com.wubaiqing.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        System.out.println("service start");
        SpringApplication.run(CommandApplication.class, args);
        System.out.println("service end");
    }

}
