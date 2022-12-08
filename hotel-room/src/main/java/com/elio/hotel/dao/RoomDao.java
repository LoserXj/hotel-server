package com.elio.hotel.dao;

import com.elio.hotel.domain.Room;
import com.elio.hotel.domain.RoomType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoomDao {

    @Insert("insert into roomType values(#{price},#{type},#{hotel_id},#{message},#{picture},#{bedNum},#{hasBreakfast})")
    void addType(RoomType type);

    @Insert("insert into room (position,hotel_id,type_id) values(#{position},#{hotel_id},#{type_id})")
    void addRoom(Room room);
    @Select("select * from room where hotel_id = #{hotel_id}")
    List<Room> selectByHotel(@Param("hotel_id")String hotel_id);

    @Insert("insert into room (hotel_id,type_id,position) values (#{hotel_id},#{type_id},#{position})")
    void insertRoom(@Param("hotel_id")String hotel_id,@Param("type_id")Integer type_id,@Param("position")String position);



    @Select("select * from room where id = #{id}")
    Room selectRoomById(@Param("id")Integer id);



}
