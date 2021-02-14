package com.shopping.portal.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemAddRequest {


    private String id;  //change to integer


    private Integer categoryId;

    @NotBlank
    private Integer deliverCityId;

    @NotBlank
    private String details;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String isBlocked;

    @NotBlank
    private String itemName;

    @NotBlank
    private String itemPrice;  //change to double

    @NotBlank
    private String itemStock; //change to integer

    @NotBlank
    private String userName;
}
