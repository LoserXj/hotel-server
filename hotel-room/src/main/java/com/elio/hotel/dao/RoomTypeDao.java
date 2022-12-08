package com.elio.hotel.dao;

import com.elio.hotel.domain.Room;
import com.elio.hotel.domain.RoomType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoomTypeDao {

    @Select("select * from room_type where hotel_id = #{hotel_id} and type = #{type}")
    RoomType selectByHotelAndType(@Param("hotel_id")String hotel_id, @Param("type")Integer type);

    @Insert("insert into room_type (price,type,hotel_id,message,picture,bedNum,hasBreakfast) values (#{price},#{type},#{hotel_id},#{message},#{picture},#{bedNum},#{hasBreakfast})")
    void insertRoomType(@Param("price")Double price,@Param("type")Integer type,@Param("hotel_id")String hotel_id,@Param("message")String message,@Param("picture")String picture,@Param("bedNum")Integer bedNum,@Param("hasBreakfast")String hasBreakfast);

    @Update("update roomType set price=#{price},bedNum=#{bedNum},hasBreakfast=#{hasBreakfast} where hotel_id=#{hotel_id} and type=#{type}")
    Integer update(RoomType type);

    @Select("select * from roomType where hotel_id=#{hotel}, type=#{type},bedNum=#{bedNum},hasBreakfast=#{hasBreakfast},price<=#{high} ")
    List<Room> getByCondition(String hotel,String type,Integer bedNum,String hasBreakfast,Double high);

    @Select("select * from room_type where hotel_id = #{hotel_id} and type = 0")
    RoomType selectRoomTypeByHotelIdAndType(@Param("hotel_id")String hotel_id);
}
