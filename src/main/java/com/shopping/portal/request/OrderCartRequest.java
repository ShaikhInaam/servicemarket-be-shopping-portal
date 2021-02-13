package com.shopping.portal.request;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCartRequest  {

    private Integer id;

    @NotBlank
    private int refId;

    @NotBlank
    private int totalPrice;

    @NotBlank
    private int orderTrackingId;

    @NotBlank
    private String userName;


}
