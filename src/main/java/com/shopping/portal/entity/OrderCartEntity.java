package com.shopping.portal.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="order_cart")
public class OrderCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ref_id")
    private Integer refId;
    @Column(name="total_price")
    private Integer totalPrice;
    @Column(name ="order_tracking_id")
    private Integer orderTrackingId;
    @Column(name = "user_name")
    private String userName;
}
