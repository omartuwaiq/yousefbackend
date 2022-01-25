package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Driver;
import com.example.FoodDelivery.model.services.DriverServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://yousefstation.herokuapp.com")
@RestController
@RequestMapping (path = "api/driver")
public class DriverController {

    private DriverServise driverService;
    @Autowired
    public DriverController(DriverServise driverService){
        this.driverService  = driverService;
    }
    @GetMapping
    public List<Driver> getDriver(){
        return driverService.getDriver();
    }
    @GetMapping(path ="{Driver_id}")
    public Optional<Driver>getDriver(@PathVariable(name = "driver_id")Integer driver_id){
    return driverService.getDriver(driver_id);
    }
    @PostMapping("add")
    public void registerNewDriver(@RequestBody Driver driver){
    driverService.addNewDriver(driver);

    }
    @DeleteMapping(path = "delete/{driver_id}")
    public void deleteDriver(@PathVariable ("driver_id")Integer driver_id){

        driverService.deleteDriver(driver_id);
    }
}
