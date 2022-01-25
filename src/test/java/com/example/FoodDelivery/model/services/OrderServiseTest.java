package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.entities.User;
import com.example.FoodDelivery.model.repository.OrderRepository;
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

class OrderServiseTest {
    @Mock
    OrderRepository orderRepository;
    @InjectMocks
    OrderServise orderServise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOrderService() {
        orderServise.OrderService(null);
    }

    @Test
    void testGetOrder() {
        List<Orders> result = orderServise.getOrder();
        Assertions.assertEquals(Arrays.<Orders>asList(new Orders(0, "type", "time", "location", new User(0, "username", "email", "password"))), result);
    }

    @Test
    void testGetOrder2() {
        Optional<Orders> result = orderServise.getOrder(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewOrder() {
        orderServise.addNewOrder(new Orders(0, "type", "time", "location", new User(0, "username", "email", "password")));
    }

    @Test
    void testDeleteOrder() {
        orderServise.deleteOrder(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme