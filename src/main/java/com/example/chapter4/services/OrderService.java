package com.example.chapter4.services;

import org.springframework.stereotype.Service;

import com.example.chapter4.mapper.OrderMapper;
import com.example.chapter4.repository.CoffeeRepository;
import com.example.chapter4.repository.OrderRepository;
import com.example.chapter4.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private CoffeeRepository coffeeRepository;
    private OrderMapper mapper;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository,
            CoffeeRepository coffeeRepository, OrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.coffeeRepository = coffeeRepository;
        this.mapper = mapper;
    }

}
