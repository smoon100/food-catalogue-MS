package com.codedecode.foodcatalogue.controller;

import com.codedecode.foodcatalogue.dto.FoodCataloguePage;
import com.codedecode.foodcatalogue.dto.FoodItemDTO;
import com.codedecode.foodcatalogue.entity.FoodItem;
import com.codedecode.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodCatalogue")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO)  {

        FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodMenu (@PathVariable Integer restaurantId) {
        FoodCataloguePage  foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails( restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
