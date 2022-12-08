package com.elio.hotel.controller;

import com.elio.hotel.domain.User;
import com.elio.hotel.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/nacos")
public class NacosOrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "insertUserAccount",method = RequestMethod.POST)
    public Integer insertUserAccount(@RequestBody User user){
        orderService.insertUserAccount(user);
        return 1;
    }
}
