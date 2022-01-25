package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Driver;
import com.example.FoodDelivery.model.repository.DriverRepository;
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

class DriverServiseTest {
    @Mock
    DriverRepository driverRepository;
    @InjectMocks
    DriverServise driverServise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDriverService() {
        driverServise.DriverService(null);
    }

    @Test
    void testGetDriver() {
        List<Driver> result = driverServise.getDriver();
        Assertions.assertEquals(Arrays.<Driver>asList(new Driver(0, "phone_numbere", "name")), result);
    }

    @Test
    void testGetDriver2() {
        Optional<Driver> result = driverServise.getDriver(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewDriver() {
        driverServise.addNewDriver(new Driver(0, "phone_numbere", "name"));
    }

    @Test
    void testDeleteDriver() {
        driverServise.deleteDriver(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme