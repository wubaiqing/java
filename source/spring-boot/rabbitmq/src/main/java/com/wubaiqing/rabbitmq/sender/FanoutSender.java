package com.wubaiqing.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int num) {
        String context = "message" + num;
        System.out.println("Fanout-Sender: " + context);
        amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }
}
