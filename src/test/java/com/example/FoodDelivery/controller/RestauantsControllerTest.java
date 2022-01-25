package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Menu;
import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.entities.Restaurants;
import com.example.FoodDelivery.model.entities.User;
import com.example.FoodDelivery.model.services.RestaurantsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class RestauantsControllerTest {
    @Mock
    RestaurantsService restaurantsService;
    @InjectMocks
    RestauantsController restauantsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetRestaurants() {
        when(restaurantsService.getRestaurants()).thenReturn(Arrays.<Restaurants>asList(new Restaurants(0, "name", "image", Arrays.<Menu>asList(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password")))))));

        List<Restaurants> result = restauantsController.getRestaurants();
        Assertions.assertEquals(Arrays.<Restaurants>asList(new Restaurants(0, "name", "image", Arrays.<Menu>asList(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password")))))), result);
    }

    @Test
    void testGetRestaurants2() {
        when(restaurantsService.getRestaurants(anyInt())).thenReturn(null);

        Optional<Restaurants> result = restauantsController.getRestaurants(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewRestaurants() {
        restauantsController.registerNewRestaurants(new Restaurants(0, "name", "image", Arrays.<Menu>asList(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password"))))));
    }

    @Test
    void testDeleteRestaurants() {
        restauantsController.deleteRestaurants(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme