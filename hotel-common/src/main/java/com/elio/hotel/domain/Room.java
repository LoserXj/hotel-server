package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Room {
    private Integer id;
    private String hotel_id;
    private Integer type_id;
    private String position;
}
