package com.wubaiqing.querysdl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wubaiqing.querysdl.entity.UserRepository;
import com.wubaiqing.querysdl.model.QUser;
import com.wubaiqing.querysdl.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
class QuerysdlApplicationTests {


    @Autowired
    private EntityManager entityManager;


    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        // 添加数据
        User userEntity = new User();
        userEntity.setUsername("wubaiqing");
        userEntity.setEmail("wubaiqing@vip.qq.com");
        userRepository.save(userEntity);

        QUser quser = QUser.user;

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        User user = queryFactory.selectFrom(quser).where(quser.username.eq("wubaiqing")).fetchOne();

        Assertions.assertEquals("wubaiqing", user.getUsername());
    }

}
