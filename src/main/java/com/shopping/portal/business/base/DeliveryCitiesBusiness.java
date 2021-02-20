package com.shopping.portal.business.base;

import com.shopping.portal.entity.DeliveryCitiesEntity;
import com.shopping.portal.Request.BaseRequest;
import com.shopping.portal.request.DeliveryCitiesRequest;
import com.shopping.portal.Response.BaseResponse;
import org.springframework.stereotype.Component;


public interface DeliveryCitiesBusiness {

    BaseResponse saveDeliveryCity(DeliveryCitiesRequest deliveryCitiesRequest);
}
