package com.shopping.portal.repository;

import com.shopping.portal.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {

    @Query(value ="select i from Item u where i.userName =?0",nativeQuery = true)
    ItemEntity findByUserName(String userName);
}
