package com.wubaiqing.mybatis;

import com.wubaiqing.mybatis.mapper.UserBeanMapper;
import com.wubaiqing.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

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
