package com.example.chapter4.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.chapter4.dto.request.RequestGetCoffee;
import com.example.chapter4.dto.response.ResponseGetCoffee;
import com.example.chapter4.mapper.CoffeeMapper;
import com.example.chapter4.model.Coffee;
import com.example.chapter4.repository.CoffeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Transactional
public class CoffeeService {

    private final CoffeeRepository repository;
    private final CoffeeMapper mapper;

    public CoffeeService(CoffeeRepository repository, CoffeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseGetCoffee create(RequestGetCoffee requestGetCoffee) {
        Coffee coffee = mapper.toEntity(requestGetCoffee);
        Coffee saved = repository.save(coffee);
        return mapper.toResponse(saved);
    }

    public List<ResponseGetCoffee> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(UUID id) {
        Coffee coffee = repository.findById(id).orElseThrow(() -> new RuntimeException());
        repository.delete(coffee);

    }
}
