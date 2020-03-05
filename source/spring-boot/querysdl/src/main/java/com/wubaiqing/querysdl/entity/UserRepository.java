package com.wubaiqing.querysdl.entity;

import com.wubaiqing.querysdl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User, String> {
    // -----
}
