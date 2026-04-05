package com.example.chapter4.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.chapter4.dto.request.RequestOrder;
import com.example.chapter4.dto.response.ResponseOrder;
import com.example.chapter4.mapper.OrderMapper;
import com.example.chapter4.model.Coffee;
import com.example.chapter4.model.Order;
import com.example.chapter4.model.User;
import com.example.chapter4.repository.CoffeeRepository;
import com.example.chapter4.repository.OrderRepository;
import com.example.chapter4.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

    public ResponseOrder createOrder(RequestOrder requestOrder) {

        Optional<Coffee> coffee = coffeeRepository.findById(requestOrder.getCoffeeId());
        if (coffee == null) {
            throw new RuntimeException("is not coffee");
        }

        Optional<User> user = userRepository.findById(requestOrder.getUserId());
        if (user == null) {
            throw new RuntimeException("is not user");
        }

        Order order = mapper.toEntity(requestOrder);

        Order saved = orderRepository.save(order);

        return mapper.toResponse(saved);
    }

    public void delete(UUID id) {
        Optional<Order> entity = orderRepository.findById(id);
        if (entity == null) {
            throw new RuntimeException("is empty order");
        }

        orderRepository.deleteById(id);
    }

    public List<ResponseOrder> findOrdersByUserName(String name) {
        User user = userRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("User not found with name: " + name));

        List<Order> orders = orderRepository.findByUserId(user.getId());

        return orders.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
