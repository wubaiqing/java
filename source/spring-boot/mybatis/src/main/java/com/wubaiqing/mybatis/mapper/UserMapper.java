package com.wubaiqing.mybatis.mapper;

import com.wubaiqing.mybatis.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAll();
}
