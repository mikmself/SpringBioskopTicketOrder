package com.example.springbioskopticketorder.service;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.User;
import com.example.springbioskopticketorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public ApiResponse<User> saveUser(User user) {
        try {
            User savedUser = repository.save(user);
            return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully", savedUser);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving user: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<User>> saveUsers(List<User> users) {
        try {
            List<User> savedUsers = repository.saveAll(users);
            return new ApiResponse<>(HttpStatus.OK.value(), "Users saved successfully", savedUsers);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving users: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<User>> getUsers() {
        try {
            List<User> userList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Users retrieved successfully", userList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving users: " + e.getMessage(), null);
        }
    }

    public ApiResponse<User> getUserById(int id) {
        try {
            User user = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "User retrieved successfully", user);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving user: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteUser(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "User removed successfully", "User removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting user: " + e.getMessage(), null);
        }
    }

    public ApiResponse<User> updateUser(User user) {
        try {
            User existingUser = repository.findById(user.getId_user()).orElse(null);
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully", repository.save(existingUser));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating user: " + e.getMessage(), null);
        }
    }
}
