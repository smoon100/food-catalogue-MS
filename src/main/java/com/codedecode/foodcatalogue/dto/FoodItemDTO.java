package com.codedecode.foodcatalogue.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private int id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private double price;
    private Integer restaurantId;
    private Integer quantity;
}
