package com.elio.hotel.dao;

import com.elio.hotel.domain.Hotel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelDao {
    /**
     * 插入酒店
     * @param name
     * @param address
     * @param city
     * @param description
     */
    @Insert("insert into hotel_hotel values (#{id}, #{name}, #{address},#{city}，#{picture} ,#{description})")
    void insertHotel(@Param("id")String id,@Param("name")String name,@Param("address")String address,@Param("city")String city,@Param("picture")String picture,@Param("description")String description);

    /**
     * 删除酒店
     * @param id 酒店 id
     * @return 删除的条数
     */
    @Delete("delete from hotel_hotel where id = #{id}")
    void deleteHotel(@Param("id") String id);

    /**
     *
     * @param name
     * @param address
     * @param description
     * @param id
     * @return 更新酒店信息
     */
    @Update("update hotel_hotel set name = #{name}, address = #{address}, city = #{city},picture=#{picture},description = #{description} where id = #{id}")
    void updateHotel(@Param("name")String name,@Param("address")String address,@Param("city")String city,@Param("picture")String picture,@Param("description")String description,@Param("id")String id);

    /**
     * 通过 id 查询酒店
     * @param id id
     * @return 酒店
     */
    @Select("select * from hotel_hotel where id = #{id}")
    Hotel getById(@Param("id") String id);

    @Select("select * from hotel_hotel")
    List<Hotel> selectAllHotel();

    @Select("select * from hotel_hotel where city = #{city}")
    List<Hotel> selectByCity(@Param("city")String city);

    @Select("select * from hotel_hotel where name like concat('%',#{name},'%')")
    List<Hotel> selectByName(@Param("name")String name);

    @Select("select * from hotel_hotel where name like concat('%',#{name},'%') and city = #{city}")
    List<Hotel> selectByNameAndCity(@Param("name")String name,@Param("city")String city);

    @Select("select * from hotel_hotel where id = #{id}")
    Hotel selectById(@Param("id")String id);

    @Insert("insert into hotel values(#{id},#{address},#{city},#{name},#{picture},#{description})")
    void addHotel(Hotel hotel);

    @Select("select * from hotel where id=#{id}")
    List<Hotel> getHotelById(String id);

}
