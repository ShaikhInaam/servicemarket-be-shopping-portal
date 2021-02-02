package com.shopping.portal.business.base;


import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.response.BaseResponse;

public interface ItemReviewBusniess {

    BaseResponse saveItemReview(ItemReviewRequest itemReviewRequest) ;
}
