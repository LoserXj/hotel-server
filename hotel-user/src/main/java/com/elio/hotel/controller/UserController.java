package com.elio.hotel.controller;


import com.elio.hotel.domain.Manager;
import com.elio.hotel.domain.User;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.UserService;

import com.elio.hotel.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @RequestMapping ("/login")
    @ResponseBody
    public RespBean verify(User user,HttpServletRequest request,HttpServletResponse response){
        return userService.verifyLogin(user.getTel(),user.getPassword(),request,response);
    }

    @RequestMapping("/manager")
    @ResponseBody
    public RespBean verifyManager(Manager manager){
        return userService.verifyManager(manager);
    }

    @RequestMapping("/managerInfo")
    public Manager selectManagerInfo(@Param("tel")String tel){
        return userService.selectManagerInfo(tel);
    }

    @RequestMapping("/getCookie")
    public User getUser(HttpSession session, @CookieValue(value = "user")String userSessionID){
       System.out.println(userSessionID);
       return(User) session.getAttribute(userSessionID);
//        return (User)request.getSession().getAttribute(userSessionID);

    }

    /**
     * 跳转进入主页面
     * @param model
     * @param userSessionID
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/homePage")
    public String toHomePage(Model model, @CookieValue("USER")String userSessionID,HttpServletRequest request,HttpServletResponse response){

        User user=(User)request.getSession().getAttribute(userSessionID);
        model.addAttribute("userInfo",user);
        return "homePage";
    }
    @RequestMapping ("/register")
    @ResponseBody
    public RespBean register(User user, HttpServletRequest request, HttpServletResponse response){
        return userService.register(user,request,response);
    }

}


