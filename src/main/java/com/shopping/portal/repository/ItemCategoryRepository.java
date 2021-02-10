package com.shopping.portal.repository;


import com.shopping.portal.entity.ItemCategoriesEntity;
import com.shopping.portal.response.ItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoriesEntity,Integer> {

    // for user


    @Query("Select e From ItemCategoriesEntity e left JOIN fetch e.items i where i.userName  <>:username and i.deliveryCityId =:cityId and i.isBlocked='No'")
    public List<ItemCategoriesEntity> getItemCategoriesForUser(@Param("username") String username, @Param("cityId")  Integer cityId);


    @Query("From ItemCategoriesEntity e left JOIN fetch e.items i")
    public List<ItemCategoriesEntity> getItemCategoriesForUser1();



    // for admin





    // General

}
