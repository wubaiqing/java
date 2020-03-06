package com.wubaiqing.rabbitmq;

import com.wubaiqing.rabbitmq.sender.HelloSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    void contextLoads() {
        helloSender.send();
    }

}
