package com.example.chapter4.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Coffee coffee;

    @ManyToOne
    private User user;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime timeCreate;

    public Order() {
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDateTime getTimeCreate() {
        return timeCreate;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTimeCreate(LocalDateTime timeCreate) {
        this.timeCreate = timeCreate;
    }

}
