package com.wubaiqing.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

@Component
public class HelloListener {

    @RabbitHandler
    public void process(String context) {
        System.out.println("Receiver: " + context);
    }
}
