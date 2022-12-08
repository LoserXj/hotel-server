package com.elio.hotel.dao;

import com.elio.hotel.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDao {

    @Insert("insert into order_order (start_time, end_time, user_id, user_name, user_tel, room_id, room_position, room_type_id," +
            "  room_price,num,total_price, hotel_id, hotel_name, hotel_address, status) values (#{start_time}, #{end_time}, " +
            "#{user_id}, #{user_name}, #{user_tel}, #{room_id}, #{room_position}, #{room_type_id}, #{room_price},#{num},#{total_price}," +
            " #{room_type_price}, #{hotel_id}, #{hotel_name}, #{hotel_address}, #{status}) ")
    void insertOrder(@Param("start_time")String start_time,@Param("end_time")String end_time,@Param("user_id")Integer user_id,
                     @Param("user_name")String user_name,@Param("user_tel")String user_tel,@Param("room_id")Integer room_id,
                     @Param("room_position")String room_position,@Param("room_type_id")Integer room_type_id,@Param("room_price")Double room_price,
                    @Param("num")Integer num,@Param("total_price")Double total_price,@Param("hotel_id")String hotel_id,
                    @Param("hotel_name")String hotel_name,@Param("hotel_address")String hotel_address,@Param("status")Integer status );


   @Update("update order_order set status = 1 and order_time = #{order_time} where id = #{id}")
   void updateOrder(@Param("id")Integer id,@Param("order_time")String order_time);

   @Select("select * from order_order where status = 0 and user_tel = #{user_tel}")
   List<Order> selectOrderByStatusAndTel(@Param("user_tel")String user_tel);

   @Select("select * from order_order where id = #{id}")
   Order selectById(@Param("id")Integer id);

   @Select("select * from order_order where user_tel = #{user_tel} and status = 0")
   List<Order> selectUnPay(@Param("user_tel")String user_tel);

   @Select("select * from order_order where user_tel = #{user_tel}")
   List<Order> selectAllOrder(@Param("user_tel")String user_tel);

}
