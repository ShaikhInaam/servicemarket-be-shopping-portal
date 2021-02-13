package com.shopping.portal.service.impl;

import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.repository.ItemCategoryRepository;
import com.shopping.portal.service.base.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategoriesEntity> getItemCategories(String username, Integer cityId){

        return itemCategoryRepository.getItemCategoriesForUser(username, cityId);

        //return itemCategoryRepository.getItemCategoriesForUser1();
    }


}
