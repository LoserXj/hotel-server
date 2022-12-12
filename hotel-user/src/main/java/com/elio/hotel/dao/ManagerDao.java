package com.elio.hotel.dao;

import com.elio.hotel.domain.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface ManagerDao {

    @Select("select * from manager_manager where tel = #{tel}")
    Manager selectManagerByTel(@Param("tel")String tel);
}
