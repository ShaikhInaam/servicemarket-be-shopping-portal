package com.shopping.portal.repository;

import com.shopping.portal.entity.DeliveryCityEntity;
import com.shopping.portal.entity.ItemReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryCityRepository  extends JpaRepository<DeliveryCityEntity,Integer> {


    @Override
    DeliveryCityEntity getOne(Integer integer);




    //String getNameById(@Param("cityId") Integer cityId);
}
