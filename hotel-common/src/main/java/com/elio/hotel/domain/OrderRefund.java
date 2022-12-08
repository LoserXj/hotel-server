package com.elio.hotel.domain;

import lombok.Data;

@Data
public class OrderRefund {
 private Integer id;
 private Integer order_id;
 private String user_id;
 private String user_name;
 private String hotel_id;
 private Integer status;

}
