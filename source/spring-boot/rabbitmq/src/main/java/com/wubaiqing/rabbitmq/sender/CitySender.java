package com.wubaiqing.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CitySender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int num) {
        String context = "City" + num;
        System.out.println("Sender: " + context);
        amqpTemplate.convertAndSend("wubaiqing", context);
    }
}
