package com.elio.hotel.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String tel;
    private String sex;
}
