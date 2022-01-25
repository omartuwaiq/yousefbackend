package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Driver;
import com.example.FoodDelivery.model.services.DriverServise;
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

class DriverControllerTest {
    @Mock
    DriverServise driverService;
    @InjectMocks
    DriverController driverController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetDriver() {
        when(driverService.getDriver()).thenReturn(Arrays.<Driver>asList(new Driver(0, "phone_numbere", "name")));

        List<Driver> result = driverController.getDriver();
        Assertions.assertEquals(Arrays.<Driver>asList(new Driver(0, "phone_numbere", "name")), result);
    }

    @Test
    void testGetDriver2() {
        when(driverService.getDriver(anyInt())).thenReturn(null);

        Optional<Driver> result = driverController.getDriver(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewDriver() {
        driverController.registerNewDriver(new Driver(0, "phone_numbere", "name"));
    }

    @Test
    void testDeleteDriver() {
        driverController.deleteDriver(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme