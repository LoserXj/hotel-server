package com.elio.hotel.domain;

import lombok.Data;


@Data
public class RoomType {
   private Double price;
   private Integer type;
   private String hotel_id;
   private String message;
   private String picture;
   private Integer bedNum;
   private String hasBreakfast;
   public RoomType(){}
   public RoomType(Double price, Integer type, String hotel_id,String message,String picture,Integer bedNum,String hasBreakfast){
      this.price=price;
      this.type=type;
      this.hotel_id=hotel_id;
      this.message=message;
      this.picture=picture;
      this.bedNum=bedNum;
      this.hasBreakfast=hasBreakfast;
   }
}
