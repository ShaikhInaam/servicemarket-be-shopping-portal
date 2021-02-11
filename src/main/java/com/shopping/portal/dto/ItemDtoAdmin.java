package com.shopping.portal.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ItemDtoAdmin {

        private  Integer id;
        private  String  itemName;
        private  String itemPrice;
        private  String details;
        private  String imageUrl;


}
