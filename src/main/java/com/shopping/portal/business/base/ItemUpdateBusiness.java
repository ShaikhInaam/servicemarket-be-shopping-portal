package com.shopping.portal.business.base;

import com.shopping.portal.Request.ItemUpdateRequest;
import com.shopping.portal.Response.BaseResponse;

public interface ItemUpdateBusiness {

    BaseResponse updateItemDetails(ItemUpdateRequest itemUpdateRequest);

}
