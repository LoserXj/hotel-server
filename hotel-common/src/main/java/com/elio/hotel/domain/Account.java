package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Account {
    private Integer user_id;
    private String tel;
    private String name;
    private String password;
    private Double balance;

}
