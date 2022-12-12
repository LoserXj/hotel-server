package com.elio.hotel.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomInfo {
    private String position;//几零几房间
    private Integer type_id;
    private Double price;
    private String hasBreakfast;
}

