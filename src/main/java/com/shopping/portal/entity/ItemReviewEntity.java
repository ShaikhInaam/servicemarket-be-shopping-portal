package com.shopping.portal.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="item_review")
public class ItemReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private Timestamp commentDate;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "username")
    private String userName;
}
