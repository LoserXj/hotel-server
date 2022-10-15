package com.elio.hotel.mapper;


import com.elio.hotel.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMapper {

    /**
     * 通过用户名字来查找改用户
     * @param name
     * @return  名字对应的用户
     */
    @Select("select * from user_user where name=#{name}")
    User findByUserName(@Param("name") String name );

    /**
     * 通过手机号查询用户
     * @param tel
     * @return  返回手机号对应的用户
     */
    @Select("select * from user_user where tel=#{tel}")
    User findByUserTel(@Param("tel") String tel );

    /**
     * 用户注册插入数据
     * @param name
     * @param password
     * @param tel
     * @param sex
     */
    @Insert("insert into user_user (name,password,tel,sex) values (#{name},#{password},#{tel},#{sex})")
    void insertIntoUser(@Param("name")String name,@Param("password")String password,@Param("tel")String tel,@Param("sex")String sex);

    /**
     * 注销用户
     * @param tel
     * @return
     */
    @Delete("delete from user_user where tel = #{tel}")
    Integer deleteByTel(String tel);

    /**
     *  查询相同名字的用户数量
     * @param name
     * @return 具有相同名字用户的数量
     */
    @Select("select COUNT(*) from user_user where name = #{name}")
    Integer countSameNameUser(String name);

    /**
     * 查询不同性别的用户数量
     * @param sex
     * @return 返回对应性别的用户数量
     */
    @Select("select COUNT(*) from user_user where sex = #{sex}")
    Integer countSex(String sex);

    /**
     * 查询所有用户的信息
     * @return 所用用户实例的 List 集合
     */
    @Select("select * from user_user")
    List<User> getAll();

    /**
     * 更改用户信息
     * @param user 更改后的用户信息实例
     * @return 如果更改成功，则返回 1，否则返回 0
     */
    @Update("update user_user set name = #{name}, password = #{password}, tel = #{tel}, " +
            " sex = #{sex} where tel = #{tel}")
    Integer update(User user);



}
