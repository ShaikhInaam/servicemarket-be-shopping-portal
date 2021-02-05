package com.shopping.portal.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  String id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ItemCategoriesEntity category;

    @NonNull
    @Column(name = "delivery_city_id")
    private  Integer deliveryCityId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private String itemPrice;

    @Column(name = "item_stock")
    private  String itemStock;

    @Column(name = "image_url")
    private  String imageUrl;

    @Column(name = "user_name")
    private  String userName;

    @Column(name = "is_blocked")
    private  String isBlocked;

    @Column(name = "details")
    private String details;


}
