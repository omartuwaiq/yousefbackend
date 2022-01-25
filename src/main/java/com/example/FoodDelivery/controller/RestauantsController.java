package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Restaurants;
import com.example.FoodDelivery.model.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://yousefstation.herokuapp.com")
@RestController
@RequestMapping(path = "api/restauants")
public class RestauantsController {
    private RestaurantsService restaurantsService;
    @Autowired
    public RestauantsController(RestaurantsService restaurantsService){
        this.restaurantsService = restaurantsService;
    }
    @GetMapping
    public List<Restaurants>getRestaurants(){
        return restaurantsService.getRestaurants();
    }
    @GetMapping(path = "{Restaurants}")
    public Optional<Restaurants>getRestaurants(@PathVariable(name="RestaurantsId")Integer RestaurantsId){
        return restaurantsService.getRestaurants(RestaurantsId);
    }
    @PostMapping("add")
    public void registerNewRestaurants(@RequestBody Restaurants restaurants){
        restaurantsService.addNewRestaurants(restaurants);
    }
    @DeleteMapping(path = "delete/{RestaurantsId}")
    public void deleteRestaurants(@PathVariable("RestaurantsId")Integer RestaurantsId){
        restaurantsService.deleteRestaurants(RestaurantsId);
    }
}
