package com.shopping.portal.service.base;

import com.shopping.portal.entity.ItemReviewEntity;

import java.util.List;

public interface ItemReviewService {

    List<ItemReviewEntity> getItemReviews(Integer itemId);
}
