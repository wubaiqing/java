package com.wubaiqing.memcached;

import com.wubaiqing.memcached.command.MemcacheRunner;
import net.spy.memcached.MemcachedClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MemcachedApplicationTests {

    @Resource
    private MemcacheRunner memcacheRunner;


    @Test
    void contextLoads() {
        MemcachedClient memcachedClient = memcacheRunner.getClient();
        memcachedClient.set("wubaiqing", 1000, "6666");
        Assertions.assertEquals("6666", memcachedClient.get("wubaiqing").toString());
    }

}
