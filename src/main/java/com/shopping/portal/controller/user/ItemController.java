package com.shopping.portal.controller.user;

import com.shopping.portal.business.user.base.ItemBusiness;
import com.shopping.portal.request.*;
import com.shopping.portal.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //admin

    @DeleteMapping("/delete/item")
    public ResponseEntity<BaseResponse> deleteItemByUserName(@Valid @RequestBody ItemDeleteRequest itemDeleteRequest){
        return ResponseEntity.ok(itemBusiness.deleteItemByUserName(itemDeleteRequest));
    }

    @PostMapping("/add/item")
    public ResponseEntity<BaseResponse> addNewItem(@Valid @RequestBody ItemAddRequest itemAddRequest){

        return ResponseEntity.ok(itemBusiness.addItem(itemAddRequest));
    }
}
