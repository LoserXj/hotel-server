package com.elio.hotel.dao;

import com.elio.hotel.domain.ManagerAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface ManagerAccountDao {
    @Select("select * from manager_account where hotel_id = #{hotel_id}")
    ManagerAccount selectManagerAccountByHotelId(@Param("hotel_id")String hotel_id);

    @Update("update manager_account set balance = #{balance} where hotel_id = #{hotel_id}")
    void updateManagerAccount(@Param("balance")double balance,@Param("hotel_id")String hotel_id);


}
