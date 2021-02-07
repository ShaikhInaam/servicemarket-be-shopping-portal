package com.shopping.portal.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_charges")
public class DeliveryChargesEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "charges")
    private Integer charges;

    @Column(name = "days")
    private  Integer days;


    @Column(name = "city_id")
    private  Integer cityId;



}
