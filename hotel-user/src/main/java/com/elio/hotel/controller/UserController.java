package com.elio.hotel.controller;

import com.elio.hotel.pojo.User;
import com.elio.hotel.service.UserService;
import com.elio.hotel.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/login")
    @ResponseBody
    public RespBean verify(User user, HttpServletResponse response, HttpServletRequest request){
      return userService.verifyLogin(user.getTel(),user.getPassword(),request,response);
    }

    @PostMapping("/register")
    @ResponseBody
    public RespBean register(User user){
        return userService.register(user);
    }




}
