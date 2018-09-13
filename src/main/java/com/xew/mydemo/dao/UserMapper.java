package com.xew.mydemo.dao;

import com.xew.mydemo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface UserMapper {
//    @Select("select * from user")
    List<User> findAll();

//    @Select("select * from User where id=#{id}")
    User findUserById(@Param("id") Long id);

//    @Delete("delete from User where id=")
}
