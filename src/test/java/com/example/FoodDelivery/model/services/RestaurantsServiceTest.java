package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Menu;
import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.entities.Restaurants;
import com.example.FoodDelivery.model.entities.User;
import com.example.FoodDelivery.model.repository.RestaurantsRepository;
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

class RestaurantsServiceTest {
    @Mock
    RestaurantsService restaurantsService;
    @Mock
    RestaurantsRepository restaurantsRepository;
    @InjectMocks
    RestaurantsService restaurantsService1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRestaurantsService() {
        restaurantsService.RestaurantsService(null);
    }

    @Test
    void testGetRestaurants() {
        List<Restaurants> result = restaurantsService.getRestaurants();
        Assertions.assertEquals(Arrays.<Restaurants>asList(new Restaurants(0, "name", "image", Arrays.<Menu>asList(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password")))))), result);
    }

    @Test
    void testGetRestaurants2() {
        Optional<Restaurants> result = restaurantsService.getRestaurants(Integer.valueOf(0));
        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    void testAddNewRestaurants() {
        restaurantsService.addNewRestaurants(new Restaurants(0, "name", "image", Arrays.<Menu>asList(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password"))))));
    }

    @Test
    void testDeleteRestaurants() {
        restaurantsService.deleteRestaurants(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme