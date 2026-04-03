package com.example.chapter4.controller;

import java.util.List;

import com.example.chapter4.dto.request.RequestUser;
import com.example.chapter4.dto.response.ResponseUser;
import com.example.chapter4.services.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseUser createUser(@RequestBody RequestUser request) {

        return service.createUser(request);
    }

    @GetMapping
    public List<ResponseUser> findAll() {
        return service.findAllUser();
    }

    @GetMapping
    public ResponseUser findByName(@RequestParam String name) {
        return service.findByNameIgnoreCase(name);
    }

    @DeleteMapping
    public void delete(String name) {
        service.deleteByName(name);
    }
}
