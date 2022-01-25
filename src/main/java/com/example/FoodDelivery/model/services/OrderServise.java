package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Orders;
import com.example.FoodDelivery.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServise {
    private OrderRepository orderRepository;

    @Autowired
    public void OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> getOrder() {
        return orderRepository.findAll();

    }

    public Optional<Orders> getOrder(Integer orderId) {
        return orderRepository.findById(orderId);

    }
    public void addNewOrder(Orders order) {
        orderRepository.save(order);
    }


    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
        //boolean exist = orderRepository.existsById(OrderId);
        // put a condition on 'exist'. if exist then delete
    }
}
