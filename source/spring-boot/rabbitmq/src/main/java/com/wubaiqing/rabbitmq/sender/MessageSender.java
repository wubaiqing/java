package com.wubaiqing.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(int num) {
        String context = "message" + num;
        System.out.println("Message-Sender: " + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void sendMessages(int num) {
        String context = "messages" + num;
        amqpTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
