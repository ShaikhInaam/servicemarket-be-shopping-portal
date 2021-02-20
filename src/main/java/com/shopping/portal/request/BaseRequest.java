package com.shopping.portal.Request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BaseRequest {

    @NotBlank
    private String transactionId;

    @NotBlank
    private String username;


}
