package com.shopping.portal.business.base;

import com.shopping.portal.request.BaseRequest;
import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.response.BaseResponse;

public interface ItemReviewBusiness {

    BaseResponse getAllReviews(ItemReviewRequest request);
}
