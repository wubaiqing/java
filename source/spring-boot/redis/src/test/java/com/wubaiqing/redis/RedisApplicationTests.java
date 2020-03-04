package com.wubaiqing.redis;

import com.wubaiqing.redis.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("name", "wubaiqing");
        assertEquals("wubaiqing", stringRedisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testObject() throws Exception {
        User user = new User("wubaiqing@vip.qq.com", "wubaiqing", "123123", "wubaiqing","2020-03-04");

        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("register", user);
        operations.set("register2", user, 1, TimeUnit.HOURS);

        boolean exists = redisTemplate.hasKey("register");
        assertEquals(true, exists);
    }

}
