package com.shopping.portal.service.base;

import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    List<ItemCategoriesEntity> getItemCategories(String username, Integer cityId);


    //Admin
    ItemEntity findByUserName(String username);

    ItemEntity save(ItemEntity itemEntity);
}
