package com.shopping.portal.repository;


import com.shopping.portal.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemSearchRepository extends JpaRepository<ItemsEntity, Integer> {

    @Query("select i from ItemsEntity i where i.itemName like '%?1%' ")
    List<ItemsEntity> findBySimilarItemName(String name);

}
