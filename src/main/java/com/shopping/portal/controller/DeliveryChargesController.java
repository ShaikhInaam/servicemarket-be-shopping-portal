package com.shopping.portal.controller;

import com.shopping.portal.business.base.DeliveryChargesBusiness;
import com.shopping.portal.request.BaseRequest;
import com.shopping.portal.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/charges")
public class DeliveryChargesController {

    @Autowired
    DeliveryChargesBusiness deliveryCharges;

    @PostMapping("/getAll")
    public ResponseEntity<BaseResponse> getAllCityCharges(@Valid @RequestBody BaseRequest request) {

        return ResponseEntity.ok(deliveryCharges.getAllCharges(request));

    }
}