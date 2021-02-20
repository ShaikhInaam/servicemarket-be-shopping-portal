package com.shopping.portal.business.user.base;


import com.shopping.portal.request.OrderCartRequest;
import com.shopping.portal.Response.BaseResponse;

public interface OrderCartBusiness  {

    BaseResponse saveOrderCart(OrderCartRequest request);
}
