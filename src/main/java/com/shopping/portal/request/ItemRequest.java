package com.shopping.portal.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemRequest extends BaseRequest{

    @NotBlank
    private Integer cityId;
}
