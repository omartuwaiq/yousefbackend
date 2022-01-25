package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.services.OrderServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://yousefstation.herokuapp.com")
@RestController
@RequestMapping (path = "api/orders")
public class OrderController {
    private OrderServise orderService;

    @Autowired
    public OrderController(OrderServise orderService) {

        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders() {

        return orderService.getOrder();
    }

    @GetMapping(path = "{orderId}")
    public Optional<Orders> getOrder(@PathVariable(name = "orderId") Integer orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping("add")
    public void registerNewOrder(@RequestBody Orders order){

        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "delete/{orderId}")
    public void deleteOrder(@PathVariable ("orderId") Integer orderId){
        orderService.deleteOrder(orderId);
    }
}
