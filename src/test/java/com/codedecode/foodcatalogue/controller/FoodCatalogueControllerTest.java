package com.codedecode.foodcatalogue.controller;

import com.codedecode.foodcatalogue.dto.FoodCataloguePage;
import com.codedecode.foodcatalogue.dto.FoodItemDTO;
import com.codedecode.foodcatalogue.service.FoodCatalogueService;
import com.codedecode.foodcatalogue.service.FoodCatalogueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FoodCatalogueControllerTest {

    @InjectMocks
    private FoodCatalogueController foodCatalogueController;

    @Mock
    private FoodCatalogueService foodCatalogueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addFoodItem_ShouldReturnCreatedStatus() {
        // Arrang
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        when(foodCatalogueService.addFoodItem(any(FoodItemDTO.class))).thenReturn(foodItemDTO);
        // Act
        ResponseEntity<FoodItemDTO> response = foodCatalogueController.addFoodItem(foodItemDTO);
        // Assert
        assert response != null;
        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() == foodItemDTO;

        verify(foodCatalogueService, times(1)).addFoodItem(foodItemDTO);

    }

    @Test
    public void fetchRestauDetailsWithFoodMenu_ShouldReturnOkStatus() {
        // Arrang
        Integer restaurantId = 1;
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();

        when(foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId)).thenReturn(foodCataloguePage);
        // Act
        ResponseEntity<FoodCataloguePage> response = foodCatalogueController.fetchRestaurantDetailsWithFoodMenu(restaurantId);
        // Assert
        assert response != null;
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == foodCataloguePage;
        verify(foodCatalogueService, times(1)).fetchFoodCataloguePageDetails(restaurantId);
    }


}
