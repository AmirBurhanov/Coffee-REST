package com.example.chapter4.controller;

import java.util.List;
import java.util.UUID;

import com.example.chapter4.dto.request.RequestGetCoffee;
import com.example.chapter4.dto.response.ResponseGetCoffee;
import com.example.chapter4.services.CoffeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CoffeeService service;

    public CoffeeController(CoffeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseGetCoffee create(@RequestBody RequestGetCoffee request) {
        return service.create(request);
    }

    @GetMapping
    public List<ResponseGetCoffee> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseGetCoffee findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

}
