package com.wubaiqing.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "wubaiqing")
public class HelloListener {

    @RabbitHandler
    public void process(String context) {
        System.out.println("Receiver: " + context);
    }
}
