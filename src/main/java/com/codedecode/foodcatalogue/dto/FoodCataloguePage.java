package com.codedecode.foodcatalogue.dto;

import com.codedecode.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
