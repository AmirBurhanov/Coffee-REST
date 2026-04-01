package com.example.chapter4.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.chapter4.dto.request.RequestUser;
import com.example.chapter4.dto.response.ResponseUser;
import com.example.chapter4.mapper.UserMapper;
import com.example.chapter4.model.User;
import com.example.chapter4.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ResponseUser> findAllUser() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ResponseUser findByUser(RequestUser user) {
        User r = repository.findByNameIgnoreCase(user.getName());
        if (r == null) {
            throw new RuntimeException("User not found");
        }
        return mapper.toResponse(r);
    }

    public void delete(RequestUser user) {
        User entity = repository.findByNameIgnoreCase(user.getName());
        if (entity == null) {
            throw new RuntimeException("not found user");
        }
        repository.delete(entity);
    }

    public void createUser(RequestUser user) {
        User newUser = repository.findByName(user.getName());
    }
}
