package com.shopping.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SearchItemsJsonResponse {
    private String item_Name;

    private String[] response;

    private String responseMessage;

    private String responseCode;
}
