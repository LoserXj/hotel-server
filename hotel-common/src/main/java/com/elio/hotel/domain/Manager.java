package com.elio.hotel.domain;

import lombok.Data;

@Data
public class Manager {
   private Integer id;
   private String name;
   private String tel;
   private String password;
   private String hotel_id;

}
