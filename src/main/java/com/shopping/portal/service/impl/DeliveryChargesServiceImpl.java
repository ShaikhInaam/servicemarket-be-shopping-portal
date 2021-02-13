package com.shopping.portal.service.user.impl;

import com.shopping.portal.entity.DeliveryChargesEntity;
import com.shopping.portal.repository.DeliveryChargesRepository;
import com.shopping.portal.service.user.base.DeliveryChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryChargesServiceImpl implements DeliveryChargesService {


    @Autowired
    DeliveryChargesRepository chargesRepository;

    @Override
    public List<DeliveryChargesEntity> getAllCharges() {
        return chargesRepository.findAll();
    }
}
