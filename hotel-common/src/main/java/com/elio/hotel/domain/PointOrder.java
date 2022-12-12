package com.elio.hotel.domain;

import lombok.Data;

@Data
public class PointOrder {
    private Integer id;
    private Integer user_id;
    private String name;
    private Integer point;
}
