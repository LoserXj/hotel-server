package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Hotel {
    private String id;
    private String name;
    private String address;
    private String city;
    private String picture;
    private String description;
}
