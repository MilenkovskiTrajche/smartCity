package com.example.smartcity.user.controller;

import com.example.smartcity.user.model.User;
import com.example.smartcity.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
                .filter(user -> user.getPassword().equals(loginRequest.getPassword()))
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.status(401).build());
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // In a stateless/simple setup, logout is handled by the frontend
        // clearing the stored user data, but we provide the endpoint for completeness.
        return ResponseEntity.ok("Logged out successfully");
    }
}