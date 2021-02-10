package com.shopping.portal.repository;

import com.shopping.portal.entity.OrderCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCartEntity,Integer> {
}
