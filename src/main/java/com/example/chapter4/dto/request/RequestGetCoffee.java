package com.example.chapter4.dto.request;

import java.math.BigDecimal;

public class RequestGetCoffee {

    private String name;

    private BigDecimal price;

    public RequestGetCoffee() {
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
