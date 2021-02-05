package com.shopping.portal.service.user.impl;

import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemReviewEntity;
import com.shopping.portal.repository.ItemCategoryRepository;
import com.shopping.portal.repository.ItemReviewRepository;
import com.shopping.portal.service.user.base.ItemReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemReviewServiceImpl implements ItemReviewService {


    @Autowired
    ItemReviewRepository itemReviewRepository;


    @Override
    public List<ItemReviewEntity> getItemReviews(Integer itemId) {
        return itemReviewRepository.getItemReviewEntityByItemId(itemId);
    }
}
