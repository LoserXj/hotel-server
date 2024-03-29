package com.elio.hotel.controller;


import com.elio.hotel.domain.Hotel;
import com.elio.hotel.domain.User;
import com.elio.hotel.pojo.NewHotel;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping("/AllHotel")
    public List<Hotel> getAllHotel(){
        return hotelService.selectAllHotel();
    }
    @RequestMapping("/getHotel")
    public List<NewHotel> getHotel(@Param("city")String city, @Param("name")String name,@Param("user_tel") String user_tel){
        if (city.equals("全部") && name==null){
            List<Hotel> hotels= hotelService.selectAllHotel();
            return hotelService.getNewHotel(hotels,user_tel);
        }
        else if (!city.equals("全部") && name==null){
            List<Hotel> hotels= hotelService.selectByCity(city);

            return hotelService.getNewHotel(hotels,user_tel);
        }else if(!city.equals("全部") && !name.equals("")){
            List<Hotel> hotels= hotelService.selectByCityAndName(name,city);

            return hotelService.getNewHotel(hotels,user_tel);
        }else {
            List<Hotel> hotels= hotelService.selectByName(name);

            return hotelService.getNewHotel(hotels,user_tel);
        }
    }

    @RequestMapping("/updateHotel")
    @ResponseBody
    public RespBean updateHotel(Hotel hotel){
        return hotelService.update(hotel);
    }

    @RequestMapping("/deleteHotel")
    public RespBean deleteHotelById(@Param("id")String id){
        return hotelService.delete(id);
    }
    @RequestMapping("/getHotelById")
    public Hotel getHotelById(@Param("id")String id){
      return hotelService.getById(id);
    }

    @RequestMapping("/insertHotel")
    @ResponseBody
    public RespBean insertHotel(Hotel hotel){
      return hotelService.insertHotel(hotel);
    }


    @PostMapping("/addHotel")
    public RespBean addHotel(@RequestParam("pic") MultipartFile pic, HttpServletRequest request){
        boolean judge = hotelService.addHotel(pic,request);
        return judge ? new RespBean(200,"注册成功",null) : new RespBean(400,"注册失败，酒店id已存在",null);
    }


}
