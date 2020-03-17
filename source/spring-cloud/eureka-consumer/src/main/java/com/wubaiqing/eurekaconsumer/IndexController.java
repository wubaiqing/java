package com.wubaiqing.eurekaconsumer;

import com.wubaiqing.eurekaconsumer.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("hello")
    public String index() {
        return helloRemote.hello("wubaiqing");
    }

}
