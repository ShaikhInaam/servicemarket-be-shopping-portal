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
@Table(name = "delivery_cities")
public class DeliveryCityEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;


    @Column(name = "name")
    private  String name;


}
