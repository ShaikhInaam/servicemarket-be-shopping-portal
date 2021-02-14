package com.shopping.portal.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemDeleteRequest {

    @NotBlank
    private String userName;

    @NotBlank
    private String itemName;
}
