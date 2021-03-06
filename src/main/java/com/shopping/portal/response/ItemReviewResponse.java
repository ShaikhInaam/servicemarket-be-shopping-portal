package com.shopping.portal.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shopping.portal.dto.ItemDto;
import com.shopping.portal.dto.ItemReviewDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemReviewResponse {

    private Boolean isUserEligibleToComment=true;
    private List<ItemReviewDto> itemReview;
}
