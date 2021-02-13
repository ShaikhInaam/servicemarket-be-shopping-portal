package com.shopping.portal.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryCitiesRequest {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String username;
}
