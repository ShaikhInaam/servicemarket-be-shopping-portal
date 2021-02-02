package com.shopping.portal.controller;

import com.shopping.portal.business.base.OrderCartBusiness;
import com.shopping.portal.request.OrderCartRequest;
import com.shopping.portal.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderCartController {

    @Autowired
    OrderCartBusiness orderCartBusiness;

    @PostMapping("/cart")
    public ResponseEntity<BaseResponse> saveOrderCart(@Validated @RequestBody OrderCartRequest orderCartRequest) {

        orderCartBusiness.saveOrderCart(orderCartRequest);
        return ResponseEntity.ok(orderCartBusiness.saveOrderCart(orderCartRequest));
    }
}
