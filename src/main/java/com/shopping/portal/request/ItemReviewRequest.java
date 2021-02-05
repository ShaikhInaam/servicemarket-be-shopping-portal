package com.shopping.portal.request;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ItemReviewRequest extends BaseRequest {

    @NotBlank
    private Integer itemId;


}
