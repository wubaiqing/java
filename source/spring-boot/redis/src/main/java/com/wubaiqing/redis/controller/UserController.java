package com.wubaiqing.redis.controller;

import com.wubaiqing.redis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class UserController {

    @RequestMapping("getUser")
    @Cacheable(value="user-key")
    public User getUser() {
        User user = new User("wubaiqing@vip.qq.com", "wubaiqing", "123123", "wubaiqing","2020-03-04");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
