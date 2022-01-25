package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.User;
import com.example.FoodDelivery.model.repository.UserRepository;
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

class UserServiseTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServise userServise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUserService() {
        userServise.UserService(null);
    }

    @Test
    void testGetUser() {
        List<User> result = userServise.getUser();
        Assertions.assertEquals(Arrays.<User>asList(new User(0, "username", "email", "password")), result);
    }

    @Test
    void testGetUser2() {
        Optional<User> result = userServise.getUser(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetCheck() {
        when(userRepository.findPasswordByUsername(anyString())).thenReturn("findPasswordByUsernameResponse");
        when(userRepository.existsByUsername(anyString())).thenReturn(Boolean.TRUE);

        String result = userServise.getCheck("username", "password");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testAddNewUser() {
        userServise.addNewUser(new User(0, "username", "email", "password"));
    }

    @Test
    void testDeleteUser() {
        userServise.deleteUser(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme