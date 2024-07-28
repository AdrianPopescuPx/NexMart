package com.nexmart.user_service.controller;

import com.nexmart.user_service.entity.User;
import com.nexmart.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
//        return ResponseEntity.ok(userService.loginUser(email, password));
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }

    @PostMapping("/{userId}/reset-password")
    public ResponseEntity<User> resetPassword(@PathVariable Long userId, @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(userId, newPassword));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/status")
    public ResponseEntity<User> updateUserStatus(@PathVariable Long userId, @RequestParam String status) {
        return ResponseEntity.ok(userService.updateUserStatus(userId, status));
    }

    @GetMapping("/search")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{userId}/role")
    public ResponseEntity<User> updateUserRole(@PathVariable Long userId, @RequestParam String role) {
        return ResponseEntity.ok(userService.updateUserRole(userId, role));
    }

}
