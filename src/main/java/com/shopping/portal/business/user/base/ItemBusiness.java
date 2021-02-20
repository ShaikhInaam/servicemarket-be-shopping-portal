package com.shopping.portal.business.user.base;

import com.shopping.portal.Request.BaseRequest;
import com.shopping.portal.Request.ItemRequest;
import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.Response.BaseResponse;

public interface ItemBusiness {

    BaseResponse getAllCategories(BaseRequest request);
    BaseResponse getJoinInformation(BaseRequest request);
    BaseResponse getAllItemsAndCategories(ItemRequest request);
    BaseResponse saveItemReview(ItemReviewRequest itemReviewRequest);
    BaseResponse getAllReviews(ItemReviewRequest request);
}
