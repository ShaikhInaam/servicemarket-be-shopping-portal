package com.shopping.portal.business.impl;

import com.shopping.portal.business.base.ItemReviewBusniess;
import com.shopping.portal.dto.ItemReviewDto;
import com.shopping.portal.entity.ItemReviewEntity;
import com.shopping.portal.repository.ItemReviewRepository;
import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.response.ItemReviewResponse;
import com.shopping.portal.service.user.base.ItemReviewService;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ItemReviewBusinessImpl implements ItemReviewBusniess {

    String user_name="";
    boolean flag_eligible = true;

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    ItemReviewService itemReviewService;

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

    @Override
    public BaseResponse getAllReviews(ItemReviewRequest request) {

        List<ItemReviewResponse> response = new ArrayList<>();
        List<ItemReviewEntity> itemReviewLists = itemReviewService.getItemReviews(request.getItemId());
        if(Objects.nonNull(itemReviewLists) && itemReviewLists.size() >0){


            List<ItemReviewDto> itemReviewDtoList = new ArrayList<>();

            for (ItemReviewEntity itemReview: itemReviewLists) {
                itemReviewDtoList.add(ItemReviewDto.builder().comment(itemReview.getComment())
                        .commentDate(itemReview.getCommentDate())
                        .userName(itemReview.getUserName())
                        .build());

//                response.add(ItemReviewResponse.builder().
//                        itemReview(itemReviewDtoList).isUserEligibleToComment(false).build());
                user_name = itemReview.getUserName();
                checkUserCommentEligibility(user_name,request);
            }

            response.add(ItemReviewResponse.builder()
                    .itemReview(itemReviewDtoList).isUserEligibleToComment(flag_eligible).build());


            return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

        }

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

    }

    private void checkUserCommentEligibility(String user_name,ItemReviewRequest request) {

        if(request.getUsername().equals(user_name)){
            flag_eligible=false;
        }

    }
}
