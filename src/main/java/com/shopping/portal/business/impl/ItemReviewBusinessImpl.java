package com.shopping.portal.business.impl;

import com.shopping.portal.business.base.ItemReviewBusniess;
import com.shopping.portal.entity.ItemReviewEntity;
import com.shopping.portal.repository.ItemReviewRepository;
import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ItemReviewBusinessImpl implements ItemReviewBusniess {


    @Autowired
    ItemReviewRepository  itemReviewRepository;

    @Autowired
    ConfigurationUtil configurationUtil;

    @Override
    public BaseResponse saveItemReview(ItemReviewRequest itemReviewRequest) {


        ItemReviewEntity itemReviewEntity = new ItemReviewEntity();

        itemReviewEntity.setId(itemReviewRequest.getId());
        itemReviewEntity.setCommentDate(new Timestamp(System.currentTimeMillis()));
        itemReviewEntity.setComment(itemReviewRequest.getComment());
        itemReviewEntity.setItemId(itemReviewRequest.getItemId());
        itemReviewEntity.setUserName(itemReviewRequest.getUserName());

        itemReviewRepository.save(itemReviewEntity);
        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(itemReviewEntity).build();

    }
}
