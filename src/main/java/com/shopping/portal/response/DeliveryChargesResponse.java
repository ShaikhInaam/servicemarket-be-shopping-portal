package com.shopping.portal.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryChargesResponse {

    private  Integer charges;
    private  Integer days;
    private  String  cityName;

}
