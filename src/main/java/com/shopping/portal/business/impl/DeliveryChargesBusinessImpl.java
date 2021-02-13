package com.shopping.portal.business.impl;

import com.shopping.portal.business.base.DeliveryChargesBusiness;
import com.shopping.portal.dto.DeliveryChargesDto;
import com.shopping.portal.dto.ItemReviewDto;
import com.shopping.portal.entity.DeliveryChargesEntity;
import com.shopping.portal.entity.ItemReviewEntity;
import com.shopping.portal.repository.DeliveryCityRepository;
import com.shopping.portal.request.BaseRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.response.DeliveryChargesResponse;
import com.shopping.portal.response.ItemReviewResponse;
import com.shopping.portal.service.user.base.DeliveryChargesService;
import com.shopping.portal.service.user.base.DeliveryCityService;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DeliveryChargesBusinessImpl implements DeliveryChargesBusiness {


    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    DeliveryChargesService chargesService;

    @Autowired
    DeliveryCityService deliveryCityService;

    @Override
    public BaseResponse getAllCharges(BaseRequest request) {
        List<DeliveryChargesResponse> response = new ArrayList<>();
        List<DeliveryChargesEntity> deliveryChargesList = chargesService.getAllCharges();
        if(Objects.nonNull(deliveryChargesList) && deliveryChargesList.size() >0) {


            List<DeliveryChargesDto> deliveryChargesDtoList = new ArrayList<>();

            for (DeliveryChargesEntity chargesEntity : deliveryChargesList) {
                deliveryChargesDtoList.add(DeliveryChargesDto.builder().charges(chargesEntity.getCharges())
                        .days(chargesEntity.getDays())
                        .cityId(chargesEntity.getCityId())

                        .build());

            }

            for (int i = 0; i < deliveryChargesDtoList.size(); i++)
            {
                response.add(DeliveryChargesResponse.builder().
                        days(deliveryChargesDtoList.get(i).getDays()).
                        charges(deliveryChargesDtoList.get(i).getCharges())
                       .cityName(deliveryCityService.getNameById(deliveryChargesDtoList.get(i).getCityId()).getName()).build());

             }
            return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

        }

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

    }
}
