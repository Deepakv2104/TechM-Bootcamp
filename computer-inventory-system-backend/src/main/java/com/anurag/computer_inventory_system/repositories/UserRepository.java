package com.anurag.computer_inventory_system.repositories;

import com.anurag.computer_inventory_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

	boolean existsByUsername(String username);

    // Add additional methods as needed
}
