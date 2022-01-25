package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Menu;
import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.entities.User;
import com.example.FoodDelivery.model.repository.MenuRepository;
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

class MenuServiseTest {
    @Mock
    MenuRepository menuRepository;
    @InjectMocks
    MenuServise menuServise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMenuService() {
        menuServise.MenuService(null);
    }

    @Test
    void testGetMenu() {
        List<Menu> result = menuServise.getMenu();
        Assertions.assertEquals(Arrays.<Menu>asList(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password")))), result);
    }

    @Test
    void testGetMenu2() {
        Optional<Menu> result = menuServise.getMenu(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewMenu() {
        menuServise.addNewMenu(new Menu(0, "name", "size", "picture", new Orders(0, "type", "time", "location", new User(0, "username", "email", "password"))));
    }

    @Test
    void testDeleteMenu() {
        menuServise.deleteMenu(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme