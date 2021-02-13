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
@Table(name = "item_categories")
public class ItemCategoriesEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(targetEntity = ItemEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="category_id",referencedColumnName = "id")
    private List<ItemEntity> items;

}
