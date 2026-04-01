package com.example.chapter4.dto.response;

import java.util.UUID;

import java.math.BigDecimal;

public class ResponseGetCoffee {

    private UUID id;
    private String name;
    private BigDecimal price;

    public ResponseGetCoffee() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
