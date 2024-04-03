package com.example.tp2_jpa_v3.repository;

import com.example.tp2_jpa_v3.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRoleName(String roleName);
}
