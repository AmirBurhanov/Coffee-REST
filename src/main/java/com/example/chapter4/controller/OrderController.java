package com.example.chapter4.controller;

import java.util.List;

import com.example.chapter4.dto.request.RequestOrder;
import com.example.chapter4.dto.response.ResponseOrder;
import com.example.chapter4.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseOrder createOrder(@RequestBody RequestOrder request) {
        return service.createOrder(request);
    }

    @GetMapping("/{name}")
    public List<ResponseOrder> getOrder(@PathVariable String name) {
        return service.findOrdersByUserName(name);
    }
}
