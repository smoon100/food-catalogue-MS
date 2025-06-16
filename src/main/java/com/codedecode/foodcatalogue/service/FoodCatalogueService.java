package com.codedecode.foodcatalogue.service;

import com.codedecode.foodcatalogue.dto.FoodCataloguePage;
import com.codedecode.foodcatalogue.dto.FoodItemDTO;
import com.codedecode.foodcatalogue.dto.Restaurant;
import com.codedecode.foodcatalogue.entity.FoodItem;
import com.codedecode.foodcatalogue.mapper.FoodItemMapper;
import com.codedecode.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSaved = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemSaved);
   }


    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        //food item list
        List<FoodItem>  foodItemList =fetchFoodItemList(restaurantId);
        // restaurant details
        Restaurant restaurantDetails =fetchRestaurantDtailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurantDetails);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurantDetails) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurantDetails);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDtailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
