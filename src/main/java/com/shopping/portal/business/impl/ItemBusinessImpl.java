package com.shopping.portal.business.impl;

import com.shopping.portal.business.base.ItemBusiness;
import com.shopping.portal.dto.ItemDto;
import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;
import com.shopping.portal.request.BaseRequest;
import com.shopping.portal.request.ItemRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.response.ItemResponse;
import com.shopping.portal.service.user.base.ItemService;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ItemBusinessImpl implements ItemBusiness {

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    ItemService itemService;




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

}
