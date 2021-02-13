package com.shopping.portal.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ItemReviewDto {

    private  String  userName;
    private  String  comment;
    private  Timestamp commentDate;


}
