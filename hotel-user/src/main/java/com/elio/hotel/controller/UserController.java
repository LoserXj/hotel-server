package com.elio.hotel.controller;

import com.elio.hotel.pojo.User;
import com.elio.hotel.service.UserService;
import com.elio.hotel.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 跳转进入主页面
     * @param model
     * @param userSessionID
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/homePage")
    public String toHomePage(Model model, @CookieValue("USER_COOKIE")String userSessionID,HttpServletRequest request,HttpServletResponse response){

        User user=(User)request.getSession().getAttribute(userSessionID);
        model.addAttribute("userInfo",user);
        return "homePage";
    }



    @PostMapping("/register")
    @ResponseBody
    public RespBean register(User user){
        return userService.register(user);
    }




}
