package com.elio.hotel.pojo;

import lombok.Data;

@Data
public class NewHotel {
    private String id;
    private String name;
    private String address;
    private String city;
    private String picture;
    private String description;
    private Boolean is_collection;
    private Double min_price;

}
