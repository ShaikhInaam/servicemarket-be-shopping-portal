package com.shopping.portal.service.base;

import com.shopping.portal.entity.ItemCategoriesEntity;

import java.util.List;

public interface ItemService {

    List<ItemCategoriesEntity> getItemCategories(String username, Integer cityId);
    List<ItemCategoriesEntity> getItemCategoriesForAdmin(String username, Integer cityId);

}
