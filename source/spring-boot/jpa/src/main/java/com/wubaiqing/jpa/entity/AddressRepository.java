package com.wubaiqing.jpa.entity;

import com.wubaiqing.jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}

