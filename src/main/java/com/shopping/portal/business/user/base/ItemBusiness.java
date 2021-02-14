package com.shopping.portal.business.user.base;

import com.shopping.portal.request.*;
import com.shopping.portal.response.BaseResponse;

public interface ItemBusiness {

    BaseResponse getAllCategories(BaseRequest request);
    BaseResponse getJoinInformation(BaseRequest request);
    BaseResponse getAllItemsAndCategories(ItemRequest request);
    BaseResponse saveItemReview(ItemReviewRequest itemReviewRequest);
    BaseResponse getAllReviews(ItemReviewRequest request);

    //admin
    BaseResponse deleteItemByUserName( ItemDeleteRequest itemDeleteRequest);

    BaseResponse addItem(ItemAddRequest itemAddRequest);
}
