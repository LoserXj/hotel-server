package com.elio.hotel.domain;

import lombok.Data;

@Data
public class DiscountRecord {
    private Integer id;
    private Integer user_id;
    private Integer discount_id;
    private Integer number;

}
