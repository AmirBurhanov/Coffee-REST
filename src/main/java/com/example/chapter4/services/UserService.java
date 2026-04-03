package com.example.chapter4.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.chapter4.dto.request.RequestUser;
import com.example.chapter4.dto.response.ResponseUser;
import com.example.chapter4.mapper.UserMapper;
import com.example.chapter4.model.User;
import com.example.chapter4.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
        Optional<User> optional = repository.findByNameIgnoreCase(user.getName());

        if (optional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return mapper.toResponse(optional.get());
    }

    public void delete(RequestUser user) {
        User entity = repository.findByNameIgnoreCase(user.getName())
                .orElseThrow(() -> new RuntimeException("User not found with name: " + user.getName()));

        repository.delete(entity);
    }

    public ResponseUser createUser(RequestUser requestUser) {
        Optional<User> newUser = repository.findByName(requestUser.getName());
        if (newUser.isPresent()) {
            throw new RuntimeException("User alredy exists with name " + requestUser.getName());
        }

        User user = mapper.toEntity(requestUser);

        User saved = repository.save(user);

        return mapper.toResponse(saved);
    }

    public ResponseUser findByNameIgnoreCase(String name) {
        User user = repository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("User not found with name: " + name));
        return mapper.toResponse(user);
    }

    public void deleteByName(String name) {
        repository.deleteByName(name);
    }
}
