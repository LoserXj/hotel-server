package com.elio.hotel.dao;

import com.elio.hotel.domain.Account;
import com.elio.hotel.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountDao {
    @Select("select * from user_account where user_id = #{id}")
    Account selectUserAccountByUserId(@Param("id")Integer id);

    @Update("update user_account set balance = #{balance} where user_id= #{user_id}")
    void updateUserAccount(@Param("balance")double balance,@Param("user_id")Integer user_id);

    @Insert("insert into user_account (user_id, tel, name, pay_password, balance) VALUES (#{user_id}, #{tel}, #{name}, #{pay_password}, #{balance})")
    void insertUserAccount(@Param("user_id")Integer user_id,@Param("tel")String tel,@Param("name")String name,@Param("pay_password")String pay_password,@Param("balance")double balance);

    @Select("select * from user_account where user_id = #{user_id} and pay_password = #{pay_password}")
    Account selectUserAccountByUserIdAndPassword(@Param("user_id")Integer user_id,@Param("pay_password")String pay_password);



}
