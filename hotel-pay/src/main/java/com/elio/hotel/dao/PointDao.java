package com.elio.hotel.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface PointDao {

    @Insert("insert into user_point (user_id, point) VALUES (#{user_id},#{point})")
    void insertPoint(@Param("user_id")Integer user_id,@Param("point")Integer point);

    @Update("update point set point = #{point} where user_id = #{user_id}")
    void updatePoint(@Param("point")Integer point,@Param("user_id")Integer user_id);


}
