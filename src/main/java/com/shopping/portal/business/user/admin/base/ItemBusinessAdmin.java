package com.shopping.portal.business.user.admin.base;

import com.shopping.portal.request.ItemRequest;
import com.shopping.portal.response.BaseResponse;

public interface ItemBusinessAdmin {

    BaseResponse getAllItemsAndCategoriesForAdmin(ItemRequest request);
}
