package com.example.twittermockup.controller;

import com.example.twittermockup.model.User;
import com.example.twittermockup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class RegisterUserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public void searchUser() {
        userService.searchUser("Test Username");
    }

    @GetMapping(value = "/registered", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/registered", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user.getUsername(), user.getFirstName(), user.getFirstName(), user.getEmail(), user.getPassword());
    }



}
