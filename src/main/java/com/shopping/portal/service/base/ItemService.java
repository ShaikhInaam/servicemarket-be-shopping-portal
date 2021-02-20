package com.shopping.portal.service.base;

import com.shopping.portal.Request.ItemUpdateRequest;
import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<ItemCategoriesEntity> getItemCategories(String username, Integer cityId);
    public void save(ItemEntity itemEntity);
    Optional<ItemEntity> findItemById(Integer id);
    Optional<ItemCategoriesEntity> findItemCategoryById(Integer id);

}
