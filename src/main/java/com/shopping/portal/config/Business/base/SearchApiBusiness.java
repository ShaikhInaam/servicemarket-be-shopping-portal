package com.shopping.portal.config.Business.base;

import com.shopping.portal.Request.BaseRequest;
import com.shopping.portal.Request.SearchItemRequest;
import com.shopping.portal.Response.BaseResponse;
import com.shopping.portal.entity.ItemsEntity;

public interface SearchApiBusiness {

    BaseResponse searchRelatedItems (SearchItemRequest request) throws Exception;
}
