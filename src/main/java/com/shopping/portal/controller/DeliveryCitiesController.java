package com.shopping.portal.controller;


import com.shopping.portal.business.base.DeliveryCitiesBusiness;
import com.shopping.portal.request.DeliveryCitiesRequest;
import com.shopping.portal.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("delivery")
public class DeliveryCitiesController {


    @Autowired
    DeliveryCitiesBusiness deliveryCitiesBusiness;


    @PostMapping("/cities")
    public ResponseEntity<BaseResponse> saveDeliveryCity(@Valid @RequestBody DeliveryCitiesRequest deliveryCitiesRequest) {

        return ResponseEntity.ok(deliveryCitiesBusiness.saveDeliveryCity(deliveryCitiesRequest));
    }
}
