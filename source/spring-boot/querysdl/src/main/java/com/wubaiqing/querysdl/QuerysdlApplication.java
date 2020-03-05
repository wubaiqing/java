package com.wubaiqing.querysdl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class QuerysdlApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerysdlApplication.class, args);
    }

}
