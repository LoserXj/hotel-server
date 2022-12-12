package com.elio.hotel.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface PointOrderDao {
    @Insert("insert into order_point ( user_id, name, point) VALUES (#{user_id},#{name},#{point})")
    void insertPointOrder(@Param("user_id")Integer user_id,@Param("name")String name , @Param("point")Integer point );
}
