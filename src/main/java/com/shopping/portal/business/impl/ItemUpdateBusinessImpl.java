package com.shopping.portal.business.impl;

import com.shopping.portal.Request.ItemUpdateRequest;
import com.shopping.portal.Response.BaseResponse;
import com.shopping.portal.business.base.ItemUpdateBusiness;
import com.shopping.portal.entity.DeliveryCitiesEntity;
import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;
import com.shopping.portal.repository.ItemCategoryRepository;
import com.shopping.portal.repository.ItemRepository;
import com.shopping.portal.service.base.ItemService;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import liquibase.pro.packaged.O;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemUpdateBusinessImpl implements ItemUpdateBusiness {

    @Autowired
    ConfigurationUtil configurationUtil;

    @Autowired
    ItemService itemService;


    @Override
    public BaseResponse updateItemDetails(ItemUpdateRequest itemUpdateRequest) {
        ItemEntity itemEntity = new ItemEntity();

        Optional<ItemEntity> itemEntityList =  itemService.findItemById(itemUpdateRequest.getId());


        Optional<ItemCategoriesEntity> itemCategoriesEntities = itemService.findItemCategoryById(itemUpdateRequest.getCategoryId());

       if(itemEntityList.isPresent() && itemCategoriesEntities.isPresent()) {

           itemEntity.setId(itemUpdateRequest.getId());
           itemEntity.setItemName(itemUpdateRequest.getItemName());
           itemEntity.setUserName(itemUpdateRequest.getUserName());
           itemEntity.setItemStock(itemUpdateRequest.getItemStock());
           itemEntity.setItemPrice(itemUpdateRequest.getItemPrice());
           itemEntity.setIsBlocked(itemUpdateRequest.getIsBlocked());
           itemEntity.setImageUrl(itemUpdateRequest.getImageUrl());
           itemEntity.setDeliveryCityId(itemUpdateRequest.getDeliveryCityId());
           itemEntity.setCategory(itemCategoriesEntities.get());
           itemEntity.setDetails(itemUpdateRequest.getDetails());
           itemService.save(itemEntity);

           return BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                   .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(itemEntity).build();
       }
        return BaseResponse.builder().responseCode(Constants.FAILURE_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.FAILURE_RESPONSE_CODE)).response(itemEntity).build();
    }
}
