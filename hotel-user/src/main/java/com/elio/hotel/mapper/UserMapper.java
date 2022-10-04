package com.elio.hotel.mapper;

import com.elio.hotel.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {

    @Select("select * from user_user where name=#{name}")
    User findByUserName(@Param("name") String name );

    @Select("select * from user_user where tel=#{tel}")
    User findByUserTel(@Param("tel") String tel );

    @Insert("insert into user_user (name,password,tel,sex) values (#{name},#{password},#{tel},#{sex})")
    void insertIntoUser(@Param("name")String name,@Param("password")String password,@Param("tel")String tel,@Param("sex")String sex);




}
