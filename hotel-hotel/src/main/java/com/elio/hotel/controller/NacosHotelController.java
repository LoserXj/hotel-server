package com.elio.hotel.controller;

import com.elio.hotel.domain.Hotel;
import com.elio.hotel.domain.Room;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/nacos")
public class NacosHotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/hotel_id",method = RequestMethod.POST)
    public Hotel selectById(@RequestBody Room room ){
        return hotelService.getById(room.getHotel_id());
    }




}
