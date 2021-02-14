package com.shopping.portal.service.impl;

import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemEntity;
import com.shopping.portal.repository.ItemCategoryRepository;
import com.shopping.portal.repository.ItemRepository;
import com.shopping.portal.service.base.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<ItemCategoriesEntity> getItemCategories(String username, Integer cityId){

        return itemCategoryRepository.getItemCategoriesForUser(username, cityId);

        //return itemCategoryRepository.getItemCategoriesForUser1();
    }

    //admin

    @Override
    public ItemEntity findByUserName(String username) {

        return itemRepository.findByUserName(username);
    }

    @Override
    public ItemEntity save(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }


}
