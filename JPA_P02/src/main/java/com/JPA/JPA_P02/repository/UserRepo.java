package com.JPA.JPA_P02.repository;

import com.JPA.JPA_P02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
        public Optional<User> findByUsername(String username);
}
