package com.codedecode.foodcatalogue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "food_item_seq", sequenceName = "food_item_seq", allocationSize = 1) // Define your sequence
    private int id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private double price;
    private Integer restaurantId;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer quantity;


}
