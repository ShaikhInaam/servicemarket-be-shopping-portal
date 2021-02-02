package com.shopping.portal.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemReviewRequest {

    private Integer id;

    @NotBlank
    private String comment;

    @NotBlank
    private Timestamp commentDate;

    @NotBlank
    private int itemId;

    @NotBlank
    private String userName;

}
