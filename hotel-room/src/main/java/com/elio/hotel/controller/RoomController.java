package com.elio.hotel.controller;

import com.elio.hotel.domain.Room;
import com.elio.hotel.domain.RoomInfo;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/addType")
    public RespBean addType(@RequestParam("pic") MultipartFile pic, HttpServletRequest request){
        boolean flag=roomService.addType(pic,request);
        return flag ? new RespBean(200,"增添成功",null) : new RespBean(400,"添加失败",null);
    }


    @PostMapping("/addRoom")
    public RespBean addRoom(HttpServletRequest request){
        boolean flag=roomService.addRoom(request);
        return flag ? new RespBean(200,"增添成功",null) : new RespBean(400,"添加失败",null);
    }


    @PostMapping("/update/{id}")
    public RespBean update(HttpServletRequest request, @PathVariable("id") String id){
        boolean flag=roomService.update(request,id);
        return flag ? new RespBean(200,"修改成功",null) : new RespBean(400,"修改失败",null);
    }

    @PostMapping ("/condition/{id}")
    public RespBean getByCondition(HttpServletRequest request,@PathVariable("id") String id){
        String type=request.getParameter("type");
        Integer bedNum= Integer.valueOf(request.getParameter("bedNum"));
        String hasBreakfast=request.getParameter("hasBreakfast");
        Double high = Double.valueOf(request.getParameter("high"));
        List<Room> rooms=roomService.getByCondition(id,type,bedNum,hasBreakfast,high);
        boolean judge = (rooms !=null);
        return judge ? new RespBean(200,"查询成功",rooms) : new RespBean(400,"查询失败", null);
    }
    @RequestMapping("/roomInfo")
    public RespBean getRoomInfo(HttpServletRequest request){
        List<RoomInfo> infos = roomService.getRoomInfo(request);
        boolean judge = (infos!=null);
        System.out.println(judge ? new RespBean(200,"查询成功",infos) : new RespBean(400,"查询失败",null));
        return judge ? new RespBean(200,"查询成功",infos) : new RespBean(400,"查询失败",null);
    }
}
