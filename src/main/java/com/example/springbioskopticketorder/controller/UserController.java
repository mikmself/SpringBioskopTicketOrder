package com.example.springbioskopticketorder.controller;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.User;
import com.example.springbioskopticketorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public ApiResponse<User> addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/adds")
    public ApiResponse<List<User>> addUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/all")
    public ApiResponse<List<User>> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<User> findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/update")
    public ApiResponse<User> updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
