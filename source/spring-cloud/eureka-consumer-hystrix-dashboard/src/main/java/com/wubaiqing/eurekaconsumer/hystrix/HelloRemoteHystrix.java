package com.wubaiqing.eurekaconsumer.hystrix;

import com.wubaiqing.eurekaconsumer.feign.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(@RequestParam(name = "name") String name) {
        return "停用 provider 服务已被熔断，传递的参数为" +name;
    }
}
