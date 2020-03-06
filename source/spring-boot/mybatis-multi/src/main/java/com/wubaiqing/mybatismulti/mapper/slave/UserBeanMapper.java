package com.wubaiqing.mybatismulti.mapper.slave;

import com.wubaiqing.mybatismulti.entity.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserBeanMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "email", column = "email")
    })
    List<UserEntity> getAll();

    @Select("select * from user where id = #{id} limit 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email")
    })
    UserEntity getOne(Long id);

}
