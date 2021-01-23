package com.shopping.portal.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="item")
public class ItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_price")
    private double itemPrice;

    @Column(name="item_stock")
    private int itemStock;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="user_name")
    private String userName;

    @Column(name="is_blocked")
    private String isBlocked;

    @Column(name="details")
    private String details;

    @Column(name="delivery_city_id")
    private int deliveryCityId;


}
