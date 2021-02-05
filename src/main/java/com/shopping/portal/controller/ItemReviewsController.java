package com.shopping.portal.controller;

import com.shopping.portal.business.base.ItemReviewBusiness;
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
@RequestMapping("/itemreview")
public class ItemReviewsController {

    @Autowired
    ItemReviewBusiness itemReviewBusiness;

    @PostMapping("/getAll")
    public ResponseEntity<BaseResponse> getAllItemsWithCategories(@Valid @RequestBody ItemReviewRequest request){

        return ResponseEntity.ok(itemReviewBusiness.getAllReviews(request));

    }
}
