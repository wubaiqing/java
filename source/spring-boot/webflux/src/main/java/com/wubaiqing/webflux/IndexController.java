package com.wubaiqing.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class IndexController {

    @GetMapping("mono")
    public Mono<Object> mono() {
        return Mono.create(monoSink -> {
            log.info("创建 Mono");
            monoSink.success("hello webflux");
        })
        .doOnSubscribe(subscription -> { //当订阅者去订阅发布者的时候，该方法会调用
            log.info("doOnSubscribe {}", subscription);
        }).doOnNext(o -> { //当订阅者收到数据时，改方法会调用
            log.info("doOnNext {}", o);
        });
    }

    @GetMapping("flux")
    public Flux<String> flux() {
        return Flux.just("hello","webflux","spring","boot");
    }
}


