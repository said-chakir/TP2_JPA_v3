package com.example.tp2_jpa_v3.service;

import com.example.tp2_jpa_v3.entities.Role;
import com.example.tp2_jpa_v3.entities.User;

public interface UserService {
    User addUser(User user);
    Role addRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);
}
