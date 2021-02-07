package com.shopping.portal.controller;

import com.shopping.portal.business.base.ItemReviewBusniess;
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
@RequestMapping("/item")
public class ItemReviewController {

    @Autowired
    ItemReviewBusniess itemReviewBusniess;


    @PostMapping("/review")
    public ResponseEntity<BaseResponse> saveItemReview(@Valid @RequestBody ItemReviewRequest itemReviewRequest) {

        return ResponseEntity.ok(itemReviewBusniess.saveItemReview(itemReviewRequest));
    }
}
