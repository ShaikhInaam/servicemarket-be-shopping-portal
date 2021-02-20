package com.shopping.portal.business.user.impl;

import com.shopping.portal.business.user.base.ItemBusiness;
import com.shopping.portal.dto.ItemDto;
import com.shopping.portal.dto.ItemReviewDto;
import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;
import com.shopping.portal.entity.ItemReviewEntity;
import com.shopping.portal.repository.ItemReviewRepository;
import com.shopping.portal.Request.BaseRequest;
import com.shopping.portal.Request.ItemRequest;
import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.Response.BaseResponse;
import com.shopping.portal.response.ItemResponse;
import com.shopping.portal.response.ItemReviewResponse;
import com.shopping.portal.service.base.ItemReviewService;
import com.shopping.portal.service.base.ItemService;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ItemBusinessImpl implements ItemBusiness {

    private String user_name="";
    private boolean flag_eligible = true;

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemReviewRepository itemReviewRepository;

    @Autowired
    ItemReviewService itemReviewService;




    @Override
    public BaseResponse getAllCategories(BaseRequest request) {


      /*  List<ItemCategoriesEntity> categoryList =  categoryRepository.findAll();
         List<CategoryItemDto> categoryItemdtoList = new ArrayList<>();

         for(ItemCategoriesEntity categories:categoryList){
             CategoryItemDto categoryItemdto = new CategoryItemDto();
             categoryItemdto.setId(categories.getId());
             categoryItemdto.setCategoryName(categories.getCategoryName());
             categoryItemdtoList.add(categoryItemdto);
         }
        System.out.println(categoryRepository.findAll().size());

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(categoryItemdtoList).build();*/


        return null;

    }

    @Override
    public BaseResponse getJoinInformation(BaseRequest request) {

     /*   List<com.shopping.portal.response.CategoryItemResponse> categoryList =  categoryRepository.getJoinInformation();

        List<CategoryItemResponse> categoryItemdtoList = new ArrayList<>();


        for(com.shopping.portal.response.CategoryItemResponse categories:categoryList){

            CategoryItemResponse categoryItemResponseDto= new CategoryItemResponse();


            categoryItemResponseDto.setCategoryName(categories.getCategoryName());

            categoryItemResponseDto.setId(categories.getId());
            categoryItemResponseDto.setItemName(categories.getItemName());
            categoryItemResponseDto.setImageUrl(categories.getImageUrl());
            categoryItemResponseDto.setItemPrice(categories.getItemPrice());
            categoryItemResponseDto.setDetails(categories.getDetails());



            categoryItemdtoList.add(categoryItemResponseDto);

        }
        System.out.println(categoryRepository.findAll().size());

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(categoryItemdtoList).build();*/


        return null;


    }

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



    public BaseResponse getAllItemsAndCategories(ItemRequest request){

        List<ItemResponse> response = new ArrayList<>();
        List<ItemCategoriesEntity> itemCategories = itemService.getItemCategories(request.getUsername(), request.getCityId());
        if(Objects.nonNull(itemCategories) && itemCategories.size() >0){

            for (ItemCategoriesEntity itemCategory: itemCategories) {

                List<ItemDto> itemDtoList = new ArrayList<>();
                for(ItemEntity itemEntity : itemCategory.getItems()){

                    itemDtoList.add(ItemDto.builder().itemName(itemEntity.getItemName())
                            .itemPrice(itemEntity.getItemPrice())
                            .details(itemEntity.getDetails())
                            .imageUrl(itemEntity.getImageUrl()).build());
                }

                response.add(ItemResponse.builder().items(itemDtoList)
                        .categoryName(itemCategory.getCategoryName()).build());

            }

            return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

        }

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

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

        if(request.getUserName().equals(user_name)){
            flag_eligible=false;
        }

    }

}
