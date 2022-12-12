package com.elio.hotel.dao;

import com.elio.hotel.domain.Discount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface DiscountDao {

    @Select("select * from discount where id = #{id}")
    Discount selectDiscountById(@Param("id")Integer id);

    @Insert("insert into discount_record (user_id, discount_id, number) VALUES (#{user_id},#{discount_id},#{number})")
    int insertDiscountRecord(@Param("user_id")Integer user_id,@Param("discount_id")Integer discount_id,@Param("number")Integer number);

    @Update("update discount set sale = sale + 1 , version = version + 1 where id = #{id} and version = #{version}")
    int updateOptimisticLock(@Param("id")Integer id,@Param("version")Integer version);


}
