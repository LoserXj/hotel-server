package com.elio.hotel.controller;

import com.elio.hotel.domain.*;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.DiscountService;
import com.elio.hotel.service.OrderService;
import com.google.common.util.concurrent.RateLimiter;
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
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscountService discountService;

    /**
     * 创建令牌桶的实例
     */
    private final RateLimiter rateLimiter = RateLimiter.create(100);


    private static int count = 0;


    @RequestMapping("/reserve")
    public RespBean reserve(@Param("user_tel")String user_tel,@Param("room_id")Integer room_id, @Param("start_time")String start_time, @Param("end_time")String end_time) throws ParseException {
       return orderService.reserve(user_tel,room_id,start_time,end_time);
    }

    @RequestMapping("/verifyPassword")
    public RespBean verifyPassword(@Param("password")String password,@Param("user_tel")String user_tel){
        User user=orderService.selectUser(user_tel);
        Account account=orderService.verifyPassword(user.getId(), password);
        if (account==null){
            return RespBean.password_error();
        }
        return RespBean.password_success();
    }

    @RequestMapping("/pay")
    public RespBean pay(@Param("order_id")Integer order_id,@Param("password")String password,@Param("user_tel")String user_tel) throws Exception {
        User user=orderService.selectUser(user_tel);
        Account account=orderService.verifyPassword(user.getId(), password);
        if (account==null){
            return RespBean.password_error();
        }
        return orderService.pay(user,order_id);

    }

    @RequestMapping("/unPay")
    public List<Order> unPay(@Param("user_tel")String user_tel){
        User user=orderService.selectUser(user_tel);
        return orderService.unPay(user);
    }

    @RequestMapping("/allOrder")
    public List<Order> allOrder(@Param("user_tel")String user_tel){
        User user=orderService.selectUser(user_tel);
        return orderService.allOrder(user);
    }

    @RequestMapping("/refund")
    public RespBean refund(@Param("order_id")Integer order_id,@Param("user_tel")String user_tel) throws ParseException {
        User user=orderService.selectUser(user_tel);
        return orderService.refund(user,order_id);
    }

    @RequestMapping("/point")
    public RespBean usePoint(@Param("user_tel")String user_tel,@Param("name")String name,@Param("point")Integer point){
        return orderService.userPoint(user_tel,name,point);
    }

    @RequestMapping("/seckill")
    public RespBean optimisticLockSold( @Param("user_id") Integer user_id,@Param("discount_id") Integer discount_id){
        log.info("user id = {},discount id = {}", user_id,discount_id);
        try {
            boolean acquire = rateLimiter.tryAcquire(1, 1, TimeUnit.SECONDS);
            if (!acquire) {
                log.error("The system is busy, please try it again later");
                return RespBean.seckill_busy();
            }
            count++;
            log.info("request times = {}", count);
           discountService.optimisticLockSold(user_id,discount_id);
            return RespBean.seckill_success();
        }catch (RuntimeException e){
          return RespBean.seckill_error();
        }
    }

}
