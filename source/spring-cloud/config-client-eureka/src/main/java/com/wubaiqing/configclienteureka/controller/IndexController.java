package com.wubaiqing.configclienteureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
        @Value("${com.wubaiqing.username}")
        private String username;

        @RequestMapping("/hello")
        public String from() {
            return this.username;
        }

}
