package com.elio.hotel.controller;

import com.elio.hotel.domain.*;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.OrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/reserve")
    public RespBean reserve(@Param("room_id")Integer room_id, @Param("start_time")String start_time, @Param("end_time")String end_time) throws ParseException {
       return orderService.reserve(room_id,start_time,end_time);
    }

    @RequestMapping("/verifyPassword")
    public RespBean verifyPassword(@Param("password")String password){
        User user=orderService.selectUser();
        Account account=orderService.verifyPassword(user.getId(), password);
        if (account==null){
            return RespBean.password_error();
        }
        return RespBean.password_success();
    }

    @RequestMapping("/pay")
    public RespBean pay(@Param("order_id")Integer order_id,@Param("password")String password) throws Exception {
        User user=orderService.selectUser();
        Account account=orderService.verifyPassword(user.getId(), password);
        if (account==null){
            return RespBean.password_error();
        }
        return orderService.pay(user,order_id);

    }

    @RequestMapping("/unPay")
    public List<Order> unPay(){
        User user=orderService.selectUser();
        return orderService.unPay(user);
    }

    @RequestMapping("/allOrder")
    public List<Order> allOrder(){
        User user=orderService.selectUser();
        return orderService.allOrder(user);
    }

    @RequestMapping("/refund")
    public RespBean refund(@Param("order_id")Integer order_id) throws ParseException {
        User user=orderService.selectUser();
        return orderService.refund(user,order_id);
    }

//    @RequestMapping("/isManager")
//    public Boolean

}
