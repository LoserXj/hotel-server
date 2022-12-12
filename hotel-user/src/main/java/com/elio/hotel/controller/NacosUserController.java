package com.elio.hotel.controller;

import com.elio.hotel.domain.Manager;
import com.elio.hotel.domain.User;
import com.elio.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/nacos")
public class NacosUserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/getUser")
    public User getUser(@RequestBody String user_tel){
        return (User) userService.selectUserByTel(user_tel);
    }


    @RequestMapping(value = "/getManager",method = RequestMethod.POST)
    public Manager getManager(@RequestBody String user_tel){
        return userService.selectManagerInfo(user_tel);
    }


}
