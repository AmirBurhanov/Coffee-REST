package com.example.chapter4.dto.response;

import java.util.UUID;

public class ResponseUser {

    private String name;
    private UUID id;

    public ResponseUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
