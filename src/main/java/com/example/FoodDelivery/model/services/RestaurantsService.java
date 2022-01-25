package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Restaurants;
import com.example.FoodDelivery.model.repository.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RestaurantsService {
private RestaurantsService restaurantsService;
    private RestaurantsRepository restaurantsRepository;

    @Autowired
    public void RestaurantsService(RestaurantsRepository restaurantsRepository){
          this.restaurantsRepository =restaurantsRepository;




}
   public List<Restaurants> getRestaurants(){
    return restaurantsRepository.findAll();
}
public Optional<Restaurants>getRestaurants(Integer RestaurantsId){
    return restaurantsRepository.findById(RestaurantsId);
}
public void addNewRestaurants( Restaurants restaurants){

    restaurantsRepository.save(restaurants);
}
  public void deleteRestaurants(Integer restaurantsId){
    restaurantsRepository.deleteById(restaurantsId);
  }






}
