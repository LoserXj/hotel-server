package com.elio.hotel.service;

import com.elio.hotel.domain.User;
import com.elio.hotel.mapper.UserMapper;

import com.elio.hotel.result.RespBean;
import com.elio.hotel.utils.CookieUtil;
import com.elio.hotel.utils.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.elio.hotel.utils.MD5Utils.inputPassToDbPass;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private String salt="1a2b3c4d";

    public RespBean verifyLogin(String tel, String password, HttpServletRequest request, HttpServletResponse response){
        User user=userMapper.findByUserTel(tel);
        if(user==null){
            return RespBean.login_error_not_exists_user();
        }
        String dbPassword=inputPassToDbPass(password,salt);
        if(!user.getPassword().equals(dbPassword)){
            return RespBean.login_error_password();
        }
        String userSessionID= UUIDUtil.uuid();
        request.getSession().setAttribute(userSessionID,user);
        CookieUtil.setCookie(request,response,"USER_COOKIE",userSessionID);
        return RespBean.login_success();

    }

    public RespBean register(User user){
        User user1=userMapper.findByUserTel(user.getTel());
        if(user1!=null){
            return RespBean.register_error();
        }
        String dbPassword=inputPassToDbPass(user.getPassword(),salt);
        user.setPassword(dbPassword);
        userMapper.insertIntoUser(user.getName(),user.getPassword(),user.getTel(),user.getSex());
        return RespBean.register_success();
    }

}
