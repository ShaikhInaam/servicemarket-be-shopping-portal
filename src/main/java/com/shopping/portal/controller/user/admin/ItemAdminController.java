package com.shopping.portal.controller.user.admin;

import com.shopping.portal.business.user.admin.base.ItemBusinessAdmin;
import com.shopping.portal.business.user.base.ItemBusiness;
import com.shopping.portal.request.BaseRequest;
import com.shopping.portal.request.ItemRequest;
import com.shopping.portal.request.ItemReviewRequest;
import com.shopping.portal.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/adminItem")
public class ItemAdminController {

    @Autowired
    ItemBusinessAdmin itemBusiness;

    @PostMapping("/get")
    public ResponseEntity<BaseResponse> getAllItemsWithCategories(@Valid @RequestBody ItemRequest request){

        return ResponseEntity.ok(itemBusiness.getAllItemsAndCategoriesForAdmin(request));

    }

}
