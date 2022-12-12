package com.elio.hotel.service;

import com.elio.hotel.dao.HotelCollectionDao;
import com.elio.hotel.dao.HotelDao;
import com.elio.hotel.domain.Collection;
import com.elio.hotel.domain.Hotel;
import com.elio.hotel.domain.RoomType;
import com.elio.hotel.domain.User;
import com.elio.hotel.pojo.NewHotel;
import com.elio.hotel.result.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private HotelCollectionDao hotelCollectionDao;

    @Autowired
    private RestTemplate restTemplate;

    public List<Hotel> selectAllHotel() {
        return hotelDao.selectAllHotel();
    }

    public List<Hotel> selectByCity(String city) {
        return hotelDao.selectByCity(city);
    }

    public RespBean insertHotel(Hotel hotel) {
        Hotel hotel1=hotelDao.selectById(hotel.getId());
        if(hotel1!=null){
           return RespBean.operation_error();
        }
        hotelDao.insertHotel(hotel.getId(),hotel.getName(), hotel.getAddress(), hotel.getCity(), hotel.getPicture(), hotel.getDescription());
        return RespBean.operation_success();
    }

    public RespBean update(Hotel hotel) {
        hotelDao.updateHotel(hotel.getName(), hotel.getAddress(), hotel.getCity(), hotel.getPicture(), hotel.getDescription(), hotel.getId());
        return RespBean.operation_success();
    }

    public RespBean delete(String id) {
        hotelDao.deleteHotel(id);
        return RespBean.operation_success();
    }

    public Hotel getById(String id) {
        return hotelDao.getById(id);
    }

    public List<Hotel> selectByName(String name) {
        return hotelDao.selectByName(name);
    }

    public List<Hotel> selectByCityAndName(String name, String city) {
        return hotelDao.selectByNameAndCity(name,city);
    }

    public boolean addHotel(MultipartFile pic, HttpServletRequest request) {
        boolean flag = true;
        Hotel hotel = new Hotel();
        String id=request.getParameter("id");
        List<Hotel> hotels =  hotelDao.getHotelById(id);
        if(hotels!=null&&hotels.size()>0){
            return false;
        }
        hotel.setId(id);
        hotel.setAddress(request.getParameter("address"));
        hotel.setCity(request.getParameter("city"));
        hotel.setName(request.getParameter("name"));
        hotel.setDescription(request.getParameter("description"));
        String picture=null;
        Date date=new Date();
        String s=date.toString();//加入时间戳，目的是为了让所有文件名都不一样
        if(pic!=null && !pic.isEmpty()){
            String fileName=pic.getOriginalFilename();
            String filePath="D:\\hotelPic";
            File file = new File(filePath+"\\"+fileName);
            picture=filePath+"\\"+fileName;
            try {
                pic.transferTo(file);
            } catch (IOException e) {
                flag=false;
                e.printStackTrace();
            }
        }
        hotel.setPicture(picture);
        hotelDao.addHotel(hotel);
        return flag;
    }


    public List<Collection> selectCollectionByUserTel(String user_tel){
        return hotelCollectionDao.selectCollectionByUserTel(user_tel);
    }

    public User getUser(){
        return restTemplate.getForObject("http://userService/nacos/getUser",User.class);
    }

    public RoomType selectRoomTypeByHotelIdAndType(Hotel hotel){
        return restTemplate.postForObject("http://roomService/nacos/selectRoomTypeByHotelIdAndType",hotel,RoomType.class);
    }
    public List<NewHotel> getNewHotel(List<Hotel> hotels,String user_tel) {

        List<Collection> collections = selectCollectionByUserTel(user_tel);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Collection collection : collections) {
            hashMap.put(collection.getHotel_id(),1);
        }
        List<NewHotel> newHotels=new ArrayList<>();
        for(Hotel hotel : hotels){
            boolean is_collection=false;
            RoomType roomType=selectRoomTypeByHotelIdAndType(hotel);
            double price=roomType.getPrice();
            if(hashMap.containsKey(hotel.getId())){
                is_collection=true;
            }
            newHotels.add(setNewHotel(hotel,price,is_collection));
        }
        return newHotels;
    }

    public NewHotel setNewHotel(Hotel hotel,Double price,boolean is_collection){
        NewHotel newHotel=new NewHotel();
        newHotel.setId(hotel.getId());
        newHotel.setIs_collection(is_collection);
        newHotel.setAddress(hotel.getAddress());
        newHotel.setMin_price(price);
        newHotel.setCity(hotel.getCity());
        newHotel.setDescription(hotel.getDescription());
        newHotel.setName(hotel.getName());
        newHotel.setPicture(hotel.getPicture());
        return newHotel;
    }



}