package com.wubaiqing.mybatismulti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wubaiqing.mybatismulti.mapper")
public class MybatisMultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMultiApplication.class, args);
    }

}
