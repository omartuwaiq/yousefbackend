package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Driver;
import com.example.FoodDelivery.model.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServise {
    private DriverRepository driverRepository;
    @Autowired
    public void DriverService(DriverRepository driverRepository)
    {this.driverRepository = driverRepository;
    }

   public List<Driver> getDriver(){
        return driverRepository.findAll();

   }
   public Optional<Driver> getDriver(Integer driver_id){

        return driverRepository.findById(driver_id);
   }
   public void addNewDriver(Driver driver){

        driverRepository.save(driver);
   }
    public  void deleteDriver(Integer driver_id){
        driverRepository.deleteById(driver_id);

    }


}
