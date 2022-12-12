package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Discount {
    private Integer id;
    private String name;
    private Integer discount_price ;
    private Integer version;
    private Integer stock;
    private Integer sale;
}
