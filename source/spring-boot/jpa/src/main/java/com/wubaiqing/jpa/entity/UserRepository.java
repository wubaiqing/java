package com.wubaiqing.jpa.entity;

import com.wubaiqing.jpa.model.User;
import com.wubaiqing.jpa.model.Address;
import com.wubaiqing.jpa.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {

    @Query("select u.id as id, u.userName as userName, u.passWord as passWord, ad.city as city from User u, Address ad where u.id = ad.userId")
    UserInfo findUserAddress(Long id);

    User findByUserName(String userName);

    int countByUserName(String userName);

    Page<User> findAll(Pageable pageable);

    Page<User> findTop10ByUserName(String userName, Pageable pageable);

    @Transactional
    @Query("select count(u) from User u where u.userName = ?1")
    int getOne(String userName);
}

