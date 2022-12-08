package com.elio.hotel.domain;

import lombok.Data;

@Data
public class OrderStatusLog {
   private Integer order_id;
   private String change_time;
   private String info;
}
