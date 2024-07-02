package com.anurag.computer_inventory_system.services;

import com.anurag.computer_inventory_system.entities.User;
import java.util.List;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    List<User> findAll();
}