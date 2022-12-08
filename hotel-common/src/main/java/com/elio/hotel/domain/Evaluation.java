package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Evaluation {
    private Integer order_id;
    private Integer user_id;
    private Integer room_id;
    private String hotel_id;
    private Integer score;
    private String pic;
    private String context;
    private String video;



}
