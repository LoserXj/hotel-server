package com.elio.hotel.controller;

import com.elio.hotel.domain.Hotel;
import com.elio.hotel.domain.Room;
import com.elio.hotel.domain.RoomBookTime;
import com.elio.hotel.domain.RoomType;
import com.elio.hotel.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/nacos")
public class NacosRoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("/selectRoomById/{id}")
    public Room selectRoomById(@PathVariable("id")Integer id){
        return roomService.selectRoomById(id);
    }

    @RequestMapping("/selectByHotelAndType")
    public RoomType selectByHotelAndType(@RequestBody Room room){
        return roomService.selectByHotelAndType(room.getHotel_id(),room.getType_id());
    }

    @RequestMapping("/selectRoomBookTimeByRoomId")
    public RoomBookTime selectRoomBookTimeByRoomId(@RequestBody Room room){
        return roomService.selectRoomBookTimeByRoomId(room.getId());
    }

    @RequestMapping("/selectRoomTypeByHotelIdAndType")
    public RoomType selectRoomTypeByHotelIdAndType(@RequestBody Hotel hotel){
        return roomService.selectRoomTypeByHotelIdAndType(hotel.getId());
    }



}
