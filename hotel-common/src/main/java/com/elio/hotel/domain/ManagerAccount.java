package com.elio.hotel.domain;

import lombok.Data;

@Data
public class ManagerAccount {
    private Integer id;
    private String hotel_id;
    private String password;
    private Double balance;
}
