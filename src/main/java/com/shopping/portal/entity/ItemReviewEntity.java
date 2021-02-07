package com.shopping.portal.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_review")
public class ItemReviewEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "comment")
    private  String comment;

    @Column(name = "comment_date")
    private Timestamp commentDate;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "username")
    private String userName;
}
