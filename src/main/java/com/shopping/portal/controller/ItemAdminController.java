package com.shopping.portal.controller;

import com.shopping.portal.Request.BaseRequest;
import com.shopping.portal.Request.ItemRequest;
import com.shopping.portal.Request.ItemUpdateRequest;
import com.shopping.portal.Response.BaseResponse;
import com.shopping.portal.business.base.ItemUpdateBusiness;
import com.shopping.portal.business.user.base.ItemBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/itemAdmin")
public class ItemAdminController {

    @Autowired
    ItemUpdateBusiness itemUpdateBusinessBusiness;


    @PostMapping("/update")
    public ResponseEntity<BaseResponse> updateItem(@Valid @RequestBody ItemUpdateRequest request){

        return ResponseEntity.ok(itemUpdateBusinessBusiness.updateItemDetails(request));

    }


}
