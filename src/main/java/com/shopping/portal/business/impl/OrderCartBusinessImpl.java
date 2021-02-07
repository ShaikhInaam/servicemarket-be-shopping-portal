package com.shopping.portal.business.impl;

import com.shopping.portal.business.base.OrderCartBusiness;
import com.shopping.portal.entity.OrderCartEntity;
import com.shopping.portal.repository.OrderCartRepository;
import com.shopping.portal.request.OrderCartRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCartBusinessImpl  implements OrderCartBusiness {

    @Autowired
    OrderCartRepository orderCartRepository;

    @Autowired
    ConfigurationUtil configurationUtil;

    @Override
    public BaseResponse saveOrderCart(OrderCartRequest request) {


            OrderCartEntity orderCartEntity = new OrderCartEntity();
            orderCartEntity.setId(request.getId());
            orderCartEntity.setRefId(request.getRefId());
            orderCartEntity.setTotalPrice(request.getTotalPrice());
            orderCartEntity.setOrderTrackingId(request.getOrderTrackingId());
            orderCartEntity.setUserName(request.getUserName());

            orderCartRepository.save(orderCartEntity);

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(orderCartEntity).build();

    }
}
