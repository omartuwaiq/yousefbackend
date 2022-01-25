package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.entities.User;
import com.example.FoodDelivery.model.services.OrderServise;
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

class OrderControllerTest {
    @Mock
    OrderServise orderService;
    @InjectMocks
    OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetOrders() {
        when(orderService.getOrder()).thenReturn(Arrays.<Orders>asList(new Orders(0, "type", "time", "location", new User(0, "username", "email", "password"))));

        List<Orders> result = orderController.getOrders();
        Assertions.assertEquals(Arrays.<Orders>asList(new Orders(0, "type", "time", "location", new User(0, "username", "email", "password"))), result);
    }

    @Test
    void testGetOrder() {
        when(orderService.getOrder(anyInt())).thenReturn(null);

        Optional<Orders> result = orderController.getOrder(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewOrder() {
        orderController.registerNewOrder(new Orders(0, "type", "time", "location", new User(0, "username", "email", "password")));
    }

    @Test
    void testDeleteOrder() {
        orderController.deleteOrder(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme