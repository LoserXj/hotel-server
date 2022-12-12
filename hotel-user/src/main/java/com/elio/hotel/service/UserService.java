package com.elio.hotel.service;

import com.elio.hotel.dao.ManagerDao;
import com.elio.hotel.domain.Manager;
import com.elio.hotel.domain.User;
import com.elio.hotel.dao.UserMapper;

import com.elio.hotel.result.RespBean;
import com.elio.hotel.utils.CookieUtils;
import com.elio.hotel.utils.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.elio.hotel.utils.MD5Utils.inputPassToDbPass;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ManagerDao managerDao;

    private String salt="1a2b3c4d";

    public RespBean verifyLogin(String tel, String password,HttpServletRequest request,HttpServletResponse response){
        User user=userMapper.findByUserTel(tel);
        if(user==null){
            return RespBean.login_error_not_exists_user();
        }
        String dbPassword=inputPassToDbPass(password,salt);
        if(!user.getPassword().equals(dbPassword)){
            return RespBean.login_error_password();
        }
        String uuid=UUIDUtil.uuid();
        CookieUtils.setCookie(request,response,"user",uuid);
        request.getSession().setAttribute(uuid,user);

        return RespBean.login_success();

    }

    public RespBean register(User user,HttpServletRequest request,HttpServletResponse response){
        User user1=userMapper.findByUserTel(user.getTel());
        if(user1!=null){
            return RespBean.register_error();
        }
        String dbPassword=inputPassToDbPass(user.getPassword(),salt);
        user.setPassword(dbPassword);
        userMapper.insertIntoUser(user.getName(),user.getPassword(),user.getTel(),user.getSex());
        User user2=userMapper.findByUserTel(user.getTel());
        insertUserAccount(user2);
        insertPoint(user2.getId());
        return RespBean.register_success();
    }

    public void insertUserAccount(User user){
        restTemplate.postForObject("http://payService/nacos/insertUserAccount",user,Integer.class);
    }

    public void insertPoint(Integer user_id){
        restTemplate.postForObject("http://payService/nacos/insertPoint",user_id,Integer.class);
    }


    public RespBean verifyManager(Manager manager){
        Manager manager1 = managerDao.selectManagerByTel(manager.getTel());
        if(manager1==null){
            return RespBean.login_error_not_exists_user();
        }
        if(!manager1.getPassword().equals(manager.getPassword())){
            return RespBean.login_error_password();
        }
        return RespBean.login_success();
    }

    public Manager selectManagerInfo(String tel){
        System.out.println(managerDao.selectManagerByTel(tel));
        return managerDao.selectManagerByTel(tel);
    }

    public User selectUserByTel(String tel){
        return userMapper.findByUserTel(tel);
    }

}
