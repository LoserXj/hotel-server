package com.elio.hotel.service;


import com.elio.hotel.dao.RoomBookTimeDao;
import com.elio.hotel.dao.RoomDao;
import com.elio.hotel.dao.RoomTypeDao;
import com.elio.hotel.domain.Room;
import com.elio.hotel.domain.RoomBookTime;
import com.elio.hotel.domain.RoomInfo;
import com.elio.hotel.domain.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomTypeDao roomTypeDao;
    @Autowired
    private RoomBookTimeDao roomBookTimeDao;

    public Room selectRoomById(Integer id){
        return roomDao.selectRoomById(id);
    }

    public List<Room> selectRoomByHotelId(String hotel_id){
        return roomDao.selectByHotel(hotel_id);
    }

    public RoomType selectByHotelAndType(String hotel_id,Integer type){
        return roomTypeDao.selectByHotelAndType(hotel_id,type);
    }

    public RoomBookTime selectRoomBookTimeByRoomId(Integer room_id){
        return roomBookTimeDao.selectByRoom(room_id);
    }

    public List<Room> getByCondition(String hotel, String type, Integer bedNum, String hasBreakfast, Double high) {
        return roomTypeDao.getByCondition(hotel,type,bedNum,hasBreakfast,high);
    }

    public boolean update(HttpServletRequest request, String id) {
        double price = Double.parseDouble(request.getParameter("price"));
        Integer type= Integer.valueOf(request.getParameter("type"));
        String hasBreakfast=request.getParameter("hasBreakfast");
        Integer bedNum= Integer.valueOf(request.getParameter("bedNum"));
        RoomType roomType =new RoomType();
        roomType.setType(type);
        roomType.setHasBreakfast(hasBreakfast);
        roomType.setHotel_id(id);
        roomType.setPrice(price);
        roomType.setBedNum(bedNum);
        return roomTypeDao.update(roomType)==1;
    }


    public boolean addType(MultipartFile pic, HttpServletRequest request){
        boolean flag = true;
        String hotel=request.getParameter("hotel");
        Integer type= Integer.valueOf(request.getParameter("type"));
        double price= Double.parseDouble(request.getParameter("price"));
        String message=request.getParameter("message");
        int bedNum= Integer.parseInt(request.getParameter("bedNum"));
        String hasBreakfast=request.getParameter("hasBreakfast");
        String picture=null;
        if(pic!=null && !pic.isEmpty()){
            String fileName=pic.getOriginalFilename();
            String filePath="D:\\roomPic";
            File file = new File(filePath+"\\"+fileName);
            picture=filePath+"\\"+fileName;
            try {
                pic.transferTo(file);
            } catch (IOException e) {
                flag=false;
                e.printStackTrace();
            }
        }
        if(flag){
            RoomType roomType=new RoomType(price,type,hotel,message,picture,bedNum,hasBreakfast);
            roomDao.addType(roomType);
        }
        return flag;
    }
    public boolean addRoom(HttpServletRequest request) {
        String hotelId=request.getParameter("hotelId");
        String position= request.getParameter("position");
        Integer type= Integer.valueOf(request.getParameter("type"));
        Room room = new Room();
        room.setType_id(type);
        room.setHotel_id(hotelId);
        room.setPosition(position);
        roomDao.addRoom(room);
        return true;
    }

    public RoomType selectRoomTypeByHotelIdAndType(String hotel_id){
        return roomTypeDao.selectRoomTypeByHotelIdAndType(hotel_id);
    }
    public List<RoomInfo> getRoomInfo(HttpServletRequest request) {
        return roomDao.getRoomInfo(request.getParameter("id"));
    }
}
