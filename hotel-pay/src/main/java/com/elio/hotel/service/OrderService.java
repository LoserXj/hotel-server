package com.elio.hotel.service;

import com.elio.hotel.dao.*;
import com.elio.hotel.domain.*;
import com.elio.hotel.result.RespBean;
import com.elio.hotel.service.exception.PlaceOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private ManagerAccountDao managerAccountDao;

    @Autowired
    private RefundDao refundDao;

    @Autowired
    private PointDao pointDao;

    @Autowired
    private PointOrderDao pointOrderDao;

    public void insertUserAccount(User user){
        userAccountDao.insertUserAccount(user.getId(), user.getTel(),user.getName(),user.getPassword(),1000.00);
    }
    public User selectUser(String user_tel){
        return restTemplate.postForObject("http://userService/nacos/getUser",user_tel,User.class);
    }

    public Hotel selectHotelById(Room room){
        return restTemplate.postForObject("http://hotelService/nacos/hotel_id",room,Hotel.class);
    }

    public Room selectRoomById(Integer room_id){
        return restTemplate.getForObject("http://roomService/nacos/selectRoomById/"+String.valueOf(room_id),Room.class);
    }

    public RoomType selectRoomTypeByHotelAndType(Room room){
        return restTemplate.postForObject("http://roomService/nacos/selectByHotelAndType",room,RoomType.class);
    }
    public RoomBookTime selectRoomBookTimeByRoomId(Room room){
        return restTemplate.postForObject("http://roomService/nacos/selectRoomBookTimeByRoomId",room,RoomBookTime.class);
    }

    public RespBean reserve(String user_tel,Integer room_id, String start_time, String end_time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date date_now = new Date(System.currentTimeMillis());
        String order_time=sdf.format(date_now);

        Date date_start=sdf.parse(start_time);
        Date date_end=sdf.parse(end_time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date_start);
        long time1=cal.getTimeInMillis();
        cal.setTime(date_end);
        long time2=cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        User user=selectUser(user_tel);
        Room room=selectRoomById(room_id);
        RoomType roomType=selectRoomTypeByHotelAndType(room);
        RoomBookTime roomBookTime=selectRoomBookTimeByRoomId(room);
        if(roomBookTime!=null){
            String t1=roomBookTime.getStart_time();
            String t2=roomBookTime.getEnd_time();
            Date d1=sdf.parse(t1);
            Date d2=sdf.parse(t2);
            if(date_start.after(d1) && date_start.before(d2)){
                return RespBean.reserve_error();
            }
            if(date_end.after(d1) && date_end.before(d2)){
                return RespBean.reserve_error();
            }

        }
        Hotel hotel=selectHotelById(room);
        int days=Integer.parseInt(String.valueOf(between_days));
        days+=1;
        Order order=setOrder(start_time,end_time,days,room,hotel,roomType,user,order_time);
        insertOrder(order);
        return RespBean.reserve_success();
    }

    public void insertOrder(Order order){
        orderDao.insertOrder(order.getStart_time(),order.getEnd_time(),order.getUser_id(),order.getUser_name(),order.getUser_tel(),
                order.getRoom_id(),order.getRoom_position(),order.getRoom_type_id(),order.getRoom_price(),order.getNum(),order.getTotal_price(),
                order.getHotel_id(),order.getHotel_name(),order.getHotel_address(),order.getStatus());
    }


    public Order setOrder(String start_time,String end_time,int day,Room room,Hotel hotel,RoomType roomType,User user,String order_time ){
        Order order=new Order();
        order.setStart_time(start_time);
        order.setEnd_time(end_time);
        order.setUser_id(user.getId());
        order.setUser_name(user.getName());
        order.setUser_tel(user.getTel());
        order.setRoom_id(room.getId());
        order.setRoom_position(room.getPosition());
        order.setRoom_type_id(room.getType_id());
        Double days= (double) day;
        double amount=days*roomType.getPrice();
        BigDecimal b=new BigDecimal(amount);
        double price= b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        order.setRoom_price(roomType.getPrice());
        order.setNum(day);
        order.setTotal_price(price);
        order.setHotel_id(hotel.getId());
        order.setHotel_address(hotel.getAddress());
        order.setHotel_name(hotel.getName());
        order.setStatus(0);
        order.setOrder_time(order_time);
        return order;

    }


    public Order selectOrderById(Integer id){
        return orderDao.selectById(id);
    }

    public List<Order> selectOrderByStatusAndTel(String user_tel){
        return orderDao.selectOrderByStatusAndTel(user_tel);
    }

    public Account selectUserAccountByUserId(Integer user_id){
        return userAccountDao.selectUserAccountByUserId(user_id);
    }

    public Account verifyPassword(Integer user_id,String password){
        return userAccountDao.selectUserAccountByUserIdAndPassword(user_id,password);
    }

    @Transactional
    public RespBean pay(User user,Integer order_id) throws Exception {
        Order order=selectOrderById(order_id);
        Room room = selectRoomById(order.getRoom_id());
        RoomBookTime roomBookTime= selectRoomBookTimeByRoomId(room);
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date_now = new Date(System.currentTimeMillis());
        String order_time=sdf.format(date_now);
        if (roomBookTime!=null){
            String t1=order.getStart_time();
            String t2=order.getEnd_time();
            String t3=roomBookTime.getStart_time();
            String t4=roomBookTime.getEnd_time();
            Date d1=sdf.parse(t1);
            Date d2=sdf.parse(t2);
            Date d3=sdf.parse(t3);
            Date d4=sdf.parse(t4);
            if(d1.after(d3) && d1.before(d4)){
               return RespBean.pay_error();
            }
            if(d2.after(d3)&& d2.before(d4)){
                return RespBean.pay_error();
            }
        }
        Account user_account= userAccountDao.selectUserAccountByUserId(user.getId());
        if(user_account.getBalance()<order.getTotal_price()){
            return RespBean.pay_error();
        }
        ManagerAccount managerAccount=managerAccountDao.selectManagerAccountByHotelId(order.getHotel_id());
        userAccountDao.updateUserAccount(user_account.getBalance()-order.getTotal_price(),user.getId());
        managerAccountDao.updateManagerAccount(managerAccount.getBalance()+order.getTotal_price(), managerAccount.getHotel_id() );
        orderDao.updateOrder(order_id,order_time);
        double point = order.getTotal_price()/10;
        int pointInt = (int) point;
        Point userPoint = pointDao.selectUserPointById(user.getId());
        pointDao.updatePoint(pointInt,userPoint.getUser_id());
        return RespBean.pay_success();
    }

    public List<Order> unPay(User user){
        return orderDao.selectUnPay(user.getTel());
    }

    public List<Order> allOrder(User user){
        return orderDao.selectAllOrder(user.getTel());
    }


    public RespBean refund(User user,Integer order_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Order order=orderDao.selectById(order_id);
        Account userAccount = userAccountDao.selectUserAccountByUserId(user.getId());
        ManagerAccount managerAccount=managerAccountDao.selectManagerAccountByHotelId(order.getHotel_id());
        long date_now = System.currentTimeMillis();
        String order_time_str=order.getOrder_time();
        Date order_time_date=sdf.parse(order_time_str);
        Calendar cal = Calendar.getInstance();
        cal.setTime(order_time_date);
        long order_time=cal.getTimeInMillis();
        long gap=(date_now-order_time)/(1000*3600);
        if(gap<=1){
            managerAccountDao.updateManagerAccount(managerAccount.getBalance()-order.getTotal_price(),managerAccount.getHotel_id());
            userAccountDao.updateUserAccount(userAccount.getBalance()+order.getTotal_price(),user.getId());
            refundDao.insertRefund(order_id,user.getId(),user.getName(),order.getHotel_id(),1);
            return RespBean.refund_success();
        }
        refundDao.insertRefund(order_id,user.getId(),user.getName(),order.getHotel_id(),0);
        return RespBean.refund_error();
    }

    public RespBean userPoint(String user_tel,String name,Integer point){
        User user = selectUser(user_tel);
        Point point1 = pointDao.selectUserPointById(user.getId());
        if(point1.getPoint()<point){
            return RespBean.point_error();
        }
        Integer balance = point1.getPoint() - point;
        pointDao.updatePoint(balance,point1.getUser_id());
        pointOrderDao.insertPointOrder(user.getId(),name,point);
        return RespBean.point_success();
    }

}
