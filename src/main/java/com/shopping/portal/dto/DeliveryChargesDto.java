package com.shopping.portal.dto;

import com.shopping.portal.entity.DeliveryCityEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryChargesDto {


    private  Integer charges;
    private  Integer days;
    private  Integer cityId;

}
