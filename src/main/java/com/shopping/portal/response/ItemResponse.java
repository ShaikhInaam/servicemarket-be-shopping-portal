package com.shopping.portal.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shopping.portal.dto.ItemDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponse {

       private String categoryName;
       private List<ItemDto> items;


}
