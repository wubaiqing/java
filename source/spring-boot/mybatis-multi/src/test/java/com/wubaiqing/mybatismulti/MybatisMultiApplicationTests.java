package com.wubaiqing.mybatismulti;

import com.wubaiqing.mybatismulti.mapper.slave.UserBeanMapper;
import com.wubaiqing.mybatismulti.mapper.master.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisMultiApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Test
    void contextLoads() {
        Assertions.assertEquals(1, userMapper.getAll().size());
        Assertions.assertEquals(1, userBeanMapper.getAll().size());
        Assertions.assertEquals(1, userBeanMapper.getOne(1L).getId());
    }

}
