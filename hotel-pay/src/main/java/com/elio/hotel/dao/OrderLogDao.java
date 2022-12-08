package com.elio.hotel.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface OrderLogDao {

    @Insert("insert into order_status_log (order_id, change_time, info) VALUES (#{order_id}, #{change_time}, #{info})")
    void insertOrderLog(@Param("order_id")Integer order_id,@Param("change_time")String change_time,@Param("info")String info);




}
