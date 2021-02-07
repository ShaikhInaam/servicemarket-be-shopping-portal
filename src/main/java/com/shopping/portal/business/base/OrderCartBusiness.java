package com.shopping.portal.business.base;


import com.shopping.portal.request.OrderCartRequest;
import com.shopping.portal.response.BaseResponse;

public interface OrderCartBusiness  {

    BaseResponse saveOrderCart(OrderCartRequest request);
}
