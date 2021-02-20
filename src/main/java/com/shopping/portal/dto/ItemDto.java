package com.shopping.portal.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ItemDto {

    private  String  itemName;
    private  Double itemPrice;
    private  String details;
    private  String imageUrl;

}
