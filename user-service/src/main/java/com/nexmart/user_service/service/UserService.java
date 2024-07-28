package com.nexmart.user_service.service;

import com.nexmart.user_service.entity.User;
import com.nexmart.user_service.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long userId, User user) {
        User existingUser = getUser(userId);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setRole(user.getRole());
        existingUser.setStatus(user.getStatus());
        return userRepository.save(existingUser);
    }

    public User resetPassword(Long userId, String newPassword) {
        User user = getUser(userId);
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUserStatus(Long userId, String status) {
        User user = getUser(userId);
        user.setStatus(status);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUserRole(Long userId, String role) {
        User user = getUser(userId);
        user.setRole(role);
        return userRepository.save(user);
    }

}
