package com.example.chapter4.dto.response;

import java.util.UUID;

public class ResponseOrder {

    private UUID id;
    private ResponseUser user;
    private ResponseGetCoffee coffee;
    private Integer quantity;

    public ResponseOrder() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ResponseUser getUser() {
        return user;
    }

    public void setUser(ResponseUser user) {
        this.user = user;
    }

    public ResponseGetCoffee getCoffee() {
        return coffee;
    }

    public void setCoffee(ResponseGetCoffee coffee) {
        this.coffee = coffee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
