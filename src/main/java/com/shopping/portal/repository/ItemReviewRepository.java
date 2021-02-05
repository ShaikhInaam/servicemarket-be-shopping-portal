package com.shopping.portal.repository;

import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.entity.ItemReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemReviewRepository extends JpaRepository<ItemReviewEntity,Integer> {

//    @Query("Select e From ItemReviewEntity e left JOIN fetch e.comment,e.commentDate,e.userName  where  e.itemId  =:itemId")
//    public List<ItemReviewEntity> getItemReviewForUser(@Param("itemId")  Integer itemId);

    public  List<ItemReviewEntity> getItemReviewEntityByItemId(@Param("itemId") Integer itemId);



}
