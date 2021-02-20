package com.shopping.portal.Request;

import com.shopping.portal.entity.ItemCategoriesEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemUpdateRequest {


    private  Integer Id;

    private Integer categoryId;

    private  Integer deliveryCityId;

    @NotBlank
    private String itemName;

    private Double itemPrice;

    private Integer itemStock;

    @NotBlank
    private  String imageUrl;

    @NotBlank
    private  String userName;


    @NotBlank
    private  String isBlocked;


    @NotBlank
    private String details;


}
