package com.example.chapter4.repository;

import java.util.Optional;
import java.util.UUID;

import com.example.chapter4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByNameIgnoreCase(String name);

    Optional<User> findByName(String name);

    void deleteByName(String name);
}
