package com.shopping.portal.Request;

import lombok.Data;

@Data
public class BaseRequest extends SearchItemRequest {

    private String transactionId;
    private String Username;


}
