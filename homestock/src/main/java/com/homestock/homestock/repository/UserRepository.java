package com.homestock.homestock.repository;

import com.homestock.homestock.entitites.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    public User create(User user);
    public Optional<User> findByEmail(String email);
}
