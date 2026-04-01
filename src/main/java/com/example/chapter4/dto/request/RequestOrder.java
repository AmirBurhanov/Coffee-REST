package com.example.chapter4.dto.request;

import java.util.UUID;

public class RequestOrder {
    private UUID userId;
    private UUID coffeeId;
    private Integer quantity;

    public RequestOrder() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(UUID coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public RequestOrder(UUID userId, UUID coffeeId, Integer quantity) {
        this.userId = userId;
        this.coffeeId = coffeeId;
        this.quantity = quantity;
    }

}
