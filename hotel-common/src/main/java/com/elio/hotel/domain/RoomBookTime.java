package com.elio.hotel.domain;

import lombok.Data;

@Data
public class RoomBookTime {
 private Integer order_id;
 private Integer room_id;
 private String start_time;
 private String end_time;
}
