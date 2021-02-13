package com.shopping.portal.controller;

import com.shopping.portal.Request.BaseRequest;
import com.shopping.portal.Response.BaseResponse;
import com.shopping.portal.config.Business.base.SearchApiBusiness;
import com.shopping.portal.entity.ItemsEntity;
import com.shopping.portal.repository.ItemSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class SearchController {

    @Autowired
    private ItemSearchRepository itemSearchRepository;


    @PostMapping("/search")
    public List<ItemsEntity> findAll(@RequestParam String name){
        return itemSearchRepository.findBySimilarItemName(name);

    }



}
