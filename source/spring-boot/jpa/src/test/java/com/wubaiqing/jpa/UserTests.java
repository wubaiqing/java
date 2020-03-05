package com.wubaiqing.jpa;

import com.wubaiqing.jpa.entity.UserRepository;
import com.wubaiqing.jpa.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.DateFormat;
import java.util.Date;

@SpringBootTest
class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("wubaiqing", "wubaiqing@vip.qq.com"));
        Assertions.assertEquals(1, userRepository.findAll().size());
    }

    @Test
    public void testBaseQuery() throws Exception {
        User user = new User("wubaiqing", "wubaiqing@vip.qq.com");
        userRepository.findAll();
        userRepository.save(user);

        user.setId(1L);
        userRepository.delete(user);
        Assertions.assertEquals(userRepository.count(), 0);
    }

    @Test
    public void testFindBy() throws Exception {
        User user = new User("wubaiqing", "wubaiqing@vip.qq.com");
        userRepository.save(user);

        User userEntity = userRepository.findByUserName("wubaiqing");
        Assertions.assertEquals("wubaiqing", userEntity.getUserName());
        Assertions.assertEquals(1, userRepository.countByUserName("wubaiqing"));
    }

    @Test
    public void testPageable() {
        userRepository.save(new User("wubaiqing", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing1", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing2", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing3", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing4", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing5", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing6", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing7", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing8", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing10", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing9", "wubaiqing@vip.qq.com"));
        userRepository.save(new User("wubaiqing11", "wubaiqing@vip.qq.com"));

        int page = 1, size = 2;
        Pageable pageable = PageRequest.of(page, size);
        Page<User> user = userRepository.findAll(pageable);
        Assertions.assertEquals(2, user.getSize());

//        Page<User> allPage = userRepository.findTop10ByUserName("wubaiqing", pageable);
//        List<User> content = allPage.getContent();
//        Assertions.assertEquals(false, content.isEmpty());
    }


    @Test
    public void testCustom() {
        userRepository.save(new User("wubaiqing", "wubaiqing@vip.qq.com"));
        int userCount = userRepository.getOne("wubaiqing");
        Assertions.assertEquals(1, userCount);
    }


}
