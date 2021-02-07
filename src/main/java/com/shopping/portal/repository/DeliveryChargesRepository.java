package com.shopping.portal.repository;

import com.shopping.portal.entity.DeliveryChargesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryChargesRepository extends JpaRepository<DeliveryChargesEntity,Integer> {



}
