package com.shopping.portal.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CategoryItemResponse {

    private  String  id;
    private  String  itemName;
    private  String itemPrice;
    private  String imageUrl;
    private  String details;
    private  String categoryName;





}
