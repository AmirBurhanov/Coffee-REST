package com.example.chapter4.repository;

import java.util.UUID;

import com.example.chapter4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
