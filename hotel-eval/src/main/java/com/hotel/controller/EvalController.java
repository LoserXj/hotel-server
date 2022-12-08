package com.hotel.controller;


import com.elio.hotel.domain.Evaluation;
import com.elio.hotel.result.RespBean;
import com.hotel.service.EvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/eval")
public class EvalController {

    @Autowired
    private EvalService evalService;

    @PostMapping("/insert")
    public RespBean insert(@RequestParam("pic")MultipartFile pic, @RequestParam("video")MultipartFile video, HttpServletRequest request){
        boolean flag=evalService.insert(pic,video,request);
        return flag ? new RespBean(200,"增添成功",null) : new RespBean(400,"添加失败",null);
    }

    @GetMapping
    public RespBean getAll(){
        List<Evaluation> list=evalService.getAll();
        return new RespBean(200,"获取成功",list);
    }

    @GetMapping("/room/{roomId}")
    public RespBean getByRoom(@PathVariable("roomId") Integer roomId){
        List<Evaluation> list=evalService.getByRoom(roomId);
        boolean flag = (list!=null);
        return flag ? new RespBean(200,"获取成功",list) : new RespBean(400,"获取失败",list);
    }

    @GetMapping("/hotel/{hotelId}")
    public RespBean getByHotel(@PathVariable("hotelId") String hotelId){
        List<Evaluation> list=evalService.getByHotel(hotelId);
        boolean flag=(list!=null);
        return flag ? new RespBean(200,"获取成功",list) : new RespBean(400,"获取失败",null);
    }

    @DeleteMapping("/{id}")
    public RespBean delete(@PathVariable("id") Integer id){
        boolean flag = evalService.delete(id);
        return flag ? new RespBean(200,"删除成功",null) : new RespBean(400,"删除失败",null);
    }
}
