package com.shopping.portal.repository;

import com.shopping.portal.entity.ItemReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemReviewRepository  extends JpaRepository<ItemReviewEntity, Integer> {
}
