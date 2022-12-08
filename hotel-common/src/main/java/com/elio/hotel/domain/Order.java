package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String start_time;
    private String  end_time;
    private Integer user_id;
    private String user_name;
    private String user_tel;
    private Integer room_id;
    private String room_position;
    private Integer room_type_id;
    private Double room_price;
    private Integer num;
    private Double total_price;
    private String hotel_id;
    private String hotel_name;
    private String hotel_address;
    private Integer status;
    private String order_time;

}
