package com.shopping.portal.business.user.admin.impl;

import com.shopping.portal.business.user.admin.base.ItemBusinessAdmin;
import com.shopping.portal.dto.ItemDto;
import com.shopping.portal.dto.ItemDtoAdmin;
import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;
import com.shopping.portal.request.ItemRequest;
import com.shopping.portal.response.BaseResponse;
import com.shopping.portal.response.ItemAdminResponse;
import com.shopping.portal.response.ItemResponse;
import com.shopping.portal.service.base.ItemService;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ItemBusinessImplAdmin  implements ItemBusinessAdmin {

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    ItemService itemService;
    @Override
    public BaseResponse getAllItemsAndCategoriesForAdmin(ItemRequest request) {

        List<ItemAdminResponse> response = new ArrayList<>();
        List<ItemCategoriesEntity> itemCategories = itemService.getItemCategoriesForAdmin(request.getUsername(), request.getCityId());
        if(Objects.nonNull(itemCategories) && itemCategories.size() >0){

            for (ItemCategoriesEntity itemCategory: itemCategories) {

                List<ItemDtoAdmin> itemDtoList = new ArrayList<>();
                for(ItemEntity itemEntity : itemCategory.getItems()){

                    itemDtoList.add(ItemDtoAdmin.builder().itemName(itemEntity.getItemName())
                            .id(Integer.parseInt(itemEntity.getId()))
                            .itemPrice(itemEntity.getItemPrice())
                            .details(itemEntity.getDetails())
                            .imageUrl(itemEntity.getImageUrl()).build());
                }

                response.add(ItemAdminResponse.builder().items(itemDtoList)
                        .categoryName(itemCategory.getCategoryName()).build());


            }

            return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                    .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

        }

        return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(response).build();

    }
}
