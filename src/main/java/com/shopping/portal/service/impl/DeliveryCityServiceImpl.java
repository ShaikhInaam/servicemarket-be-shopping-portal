package com.shopping.portal.service.impl;

import com.shopping.portal.entity.DeliveryChargesEntity;
import com.shopping.portal.entity.DeliveryCityEntity;
import com.shopping.portal.repository.DeliveryCityRepository;
import com.shopping.portal.service.base.DeliveryChargesService;
import com.shopping.portal.service.user.base.DeliveryCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryCityServiceImpl implements DeliveryCityService {

    @Autowired
    DeliveryCityRepository deliveryCityRepository;

    @Override
    public DeliveryCityEntity getNameById(Integer id) {
        return deliveryCityRepository.getOne(id);
    }
}
