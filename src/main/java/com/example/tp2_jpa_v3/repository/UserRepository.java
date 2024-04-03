package com.example.tp2_jpa_v3.repository;

import com.example.tp2_jpa_v3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
