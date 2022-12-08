package com.elio.hotel.dao;



import com.elio.hotel.domain.RoomBookTime;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoomBookTimeDao {
    @Insert("insert into room_book_time (order_id,room_id,start_time,end_time) values (#{order_id},#{room_id},#{start_time},#{end_time})")
    void insertRoomBookTime(@Param("order_id")Integer order_id,@Param("room_id")Integer room_id,@Param("start_time")String start_time,@Param("end_time")String end_time);

    @Select("select * from room_book_time where room_id = #{room_id}")
    RoomBookTime selectByRoom(@Param("room_id")Integer room_id);


}
