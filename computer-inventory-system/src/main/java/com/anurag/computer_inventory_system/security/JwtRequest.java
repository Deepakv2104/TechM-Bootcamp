package com.anurag.computer_inventory_system.security;

import lombok.Data;

@Data
public class JwtRequest {

    private String username;
    private String password;

}
