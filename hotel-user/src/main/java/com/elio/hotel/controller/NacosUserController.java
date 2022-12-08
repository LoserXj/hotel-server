package com.elio.hotel.controller;

import com.elio.hotel.domain.User;
import com.elio.hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/nacos")
public class NacosUserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUserF( @CookieValue("USER_COOKIE")String userSessionID,HttpServletRequest request){

        return (User)request.getSession().getAttribute(userSessionID);
    }



}
