package com.anurag.computer_inventory_system.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private String username; // Add username field

    // Constructor without username for compatibility
    public JwtResponse(String token) {
        this.token = token;
    }
}
