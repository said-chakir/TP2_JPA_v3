package com.example.tp2_jpa_v3.service;
import com.example.tp2_jpa_v3.entities.Role;
import com.example.tp2_jpa_v3.entities.User;
import com.example.tp2_jpa_v3.repository.RoleRepository;
import com.example.tp2_jpa_v3.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        role.setRoleId(UUID.randomUUID().toString());
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


}
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("username does not exist");
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("username or password invalid");
    }
}

