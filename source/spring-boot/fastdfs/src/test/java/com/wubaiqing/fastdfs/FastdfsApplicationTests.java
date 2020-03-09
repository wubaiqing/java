package com.wubaiqing.fastdfs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FastdfsApplicationTests {

    @Test
    void contextLoads() {
        byte[] bytes = new byte[1024];
        FastDFSFile file = new FastDFSFile("123", bytes, "png");
        FastDFSClient.upload(file);
    }

}
