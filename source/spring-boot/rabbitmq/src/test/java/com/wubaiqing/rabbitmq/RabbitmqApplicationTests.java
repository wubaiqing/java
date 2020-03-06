package com.wubaiqing.rabbitmq;

import com.wubaiqing.rabbitmq.sender.*;
import com.wubaiqing.rabbitmq.sender.CitySender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private CitySender citySender;

    @Autowired
    private ShopSender shopSender;

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    void contextLoads() {
        shopSender.send(1);
    }

    @Test
    void many() {
        for (int i=0;i<100;i++){
            citySender.send(i);
            shopSender.send(i);
        }
    }

    @Test
    public void message() {
        messageSender.sendMessage(1);
        messageSender.sendMessages(100000);
    }

    @Test
    public void fanout() {
        fanoutSender.send(1);
    }
}
