package com.shopping.portal.business.impl;

import com.shopping.portal.business.base.DeliveryCitiesBusiness;
import com.shopping.portal.entity.DeliveryCitiesEntity;
import com.shopping.portal.repository.DeliveryCitiesRepository;
import com.shopping.portal.request.DeliveryCitiesRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryCitiesBusinessImpl implements DeliveryCitiesBusiness {

    @Autowired
    DeliveryCitiesRepository deliveryCitiesRepository;

    @Autowired
    ConfigurationUtil configurationUtil;

    @Override
    public BaseResponse saveDeliveryCity(DeliveryCitiesRequest deliveryCitiesRequest) {
        DeliveryCitiesEntity deliveryCitiesEntity = new DeliveryCitiesEntity();

        deliveryCitiesEntity.setId(deliveryCitiesRequest.getId());
        deliveryCitiesEntity.setName(deliveryCitiesRequest.getName());

        deliveryCitiesRepository.save(deliveryCitiesEntity);
        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(deliveryCitiesEntity).build();

    }


}
