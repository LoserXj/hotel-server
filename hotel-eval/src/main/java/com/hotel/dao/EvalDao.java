package com.hotel.dao;



import com.elio.hotel.domain.Evaluation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvalDao {

    @Insert("insert into evaluation values (#{order_id}, #{user_id}, #{room_id}, #{hotel_id}, #{score}, #{context}, #{pic}, #{video})")
    void insert(Evaluation eval);

    @Delete("delete from evaluation where order_id = #{orderId}")
    Integer delete(Integer orderId);

    @Select("select * from evaluation where room_id = #{roomId}")
    List<Evaluation> getByRoom(Integer roomId);

    @Select("select * from evaluation")
    List<Evaluation> getAll();

    @Select("select * from evaluation where hotel_id = #{hotelId}")
    List<Evaluation> getByHotel(String hotelId);
}
