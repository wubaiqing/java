package com.wubaiqing.email;

import com.wubaiqing.email.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {


    @Autowired
    private MailService mailService;

    @Test
    void contextLoads() {
        mailService.sendSimpleMail();
    }

}
