package com.example.chapter4.repository;

import java.util.UUID;

import com.example.chapter4.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, UUID> {

}
