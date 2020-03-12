package com.wubaiqing.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wubaiqing.mybatisplus.entity.User;
import com.wubaiqing.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(1L);
        Assertions.assertEquals(user.getId(), 1L);
    }

    @Test
    void testInert() {
        User user = new User();
        user.setName("wubaiqing");
        user.setEmail("wubaiqing@vip.qq.com");
        user.setAge(1);
        assertThat(userMapper.insert(user)).isGreaterThan(0);
    }

    @Test
    void testDelete() {
        assertThat(userMapper.deleteById(1L)).isGreaterThan(0);
    }

    @Test
    void testUpdate() {
        User user = userMapper.selectById(2L);
        assertThat(user.getAge()).isEqualTo(36);
        assertThat(user.getName()).isEqualTo("keep");

        userMapper.update(
                null,
                Wrappers.<User>lambdaUpdate().set(User::getEmail, "wubaiqing@vip.qq.com").eq(User::getId, 2)
        );

        assertThat(userMapper.selectById(2).getEmail()).isEqualTo("wubaiqing@vip.qq.com");
    }

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(userList.size(), 5);
        userList.forEach(System.out::println);
    }

    @Test
    void testPage() {
        Page<User> page = new Page<>(1,2);
        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>().eq("age", 6));
        assertThat(page).isSameAs(userIPage);
    }

}
