package com.elio.hotel.dao;

import com.elio.hotel.domain.Collection;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelCollectionDao {

    @Select("select * from hotel_collection where user_tel = #{user_tel}")
    List<Collection> selectCollectionByUserTel(@Param("user_tel")String user_tel);


}
