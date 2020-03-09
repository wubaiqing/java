package com.wubaiqing.memcached;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "memcache")
public class MemcacheSource {

    private String ip;

    private int port;

}
