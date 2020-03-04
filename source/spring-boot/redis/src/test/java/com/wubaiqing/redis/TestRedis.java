package com.wubaiqing.redis;

import com.wubaiqing.redis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("wubaiqing@vip.qq.com", "wubaiqing", "123123", "wubaiqing","2020-03-04");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("register", user);
        operations.set("register2", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("register");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}

