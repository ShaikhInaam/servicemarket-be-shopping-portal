package com.shopping.portal.config.Business.Imp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.portal.Request.SearchItemRequest;
import com.shopping.portal.Response.BaseResponse;
import com.shopping.portal.config.Business.base.SearchApiBusiness;
import com.shopping.portal.dto.SearchItemsJsonResponse;
import com.shopping.portal.util.ConfigurationUtil;
import com.shopping.portal.util.Constants;
import com.shopping.portal.util.RestServiceUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class SearchApiBusinessImp implements SearchApiBusiness {

    @Autowired
    ConfigurationUtil configurationUtil;
    @Autowired
    RestServiceUtility utility;

    @Override
    public BaseResponse searchRelatedItems(SearchItemRequest request) throws Exception {


        SearchItemsJsonResponse jsonResponse = null;

        BaseResponse baseResponse = BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(configurationUtil.getMessage(Constants.SUCCESS_RESPONSE_CODE)).response(jsonResponse.getResponse()).build();

        return baseResponse;
    }
    }