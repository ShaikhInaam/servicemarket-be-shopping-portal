package com.shopping.portal.controller.user;

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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemBusiness itemBusiness;

    @PostMapping("/categories")
    public ResponseEntity<BaseResponse> getAllCategories(@Valid @RequestBody BaseRequest request){

        return ResponseEntity.ok(itemBusiness.getAllCategories(request));

    }

    @PostMapping("/get")
    public ResponseEntity<BaseResponse> getAllItemsWithCategories(@Valid @RequestBody ItemRequest request){

        return ResponseEntity.ok(itemBusiness.getAllItemsAndCategories(request));

    }

    @PostMapping("/save/review")
    public ResponseEntity<BaseResponse> saveItemReview(@Valid @RequestBody ItemReviewRequest itemReviewRequest) {

        return ResponseEntity.ok(itemBusiness.saveItemReview(itemReviewRequest));
    }

    @PostMapping("/get/reviews")
    public ResponseEntity<BaseResponse> getAllItemsWithCategories(@Valid @RequestBody ItemReviewRequest request){

        return ResponseEntity.ok(itemBusiness.getAllReviews(request));

    }


}
