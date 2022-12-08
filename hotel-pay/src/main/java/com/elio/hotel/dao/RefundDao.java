package com.elio.hotel.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface RefundDao {

    @Insert("insert into order_refund (order_id, user_id, user_name, hotel_id, status) VALUES (#{order_id}, #{user_id}, #{user_name}, #{hotel_id}, #{status})")
    void insertRefund(@Param("order_id")Integer order_id,@Param("user_id")Integer user_id,@Param("user_name")String user_name,
                     @Param("hotel_id")String hotel_id, @Param("status")Integer status);

    @Update("update order_refund set status = 0 where order_id = #{order_id}")
    void updateRefund(@Param("order_id")Integer order_id);

}
