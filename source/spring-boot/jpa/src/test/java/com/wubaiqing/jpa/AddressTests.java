package com.wubaiqing.jpa;

import com.wubaiqing.jpa.entity.AddressRepository;
import com.wubaiqing.jpa.entity.UserRepository;
import com.wubaiqing.jpa.model.Address;
import com.wubaiqing.jpa.model.User;
import com.wubaiqing.jpa.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddressTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void test() throws Exception {
        User user = new User("wubaiqing", "wubaiqing@vip.qq.com");
        userRepository.save(user);
        Address address = new Address(1L, "Beijing");
        addressRepository.save(address);

        UserInfo userInfo = userRepository.findUserAddress(1L);
        Assertions.assertEquals("Beijing", userInfo.getCity());
        Assertions.assertEquals("wubaiqing", userInfo.getUserName());
    }

}
