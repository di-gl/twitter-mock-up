package com.example.twittermockup.controller;

import com.example.twittermockup.model.User;
import com.example.twittermockup.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /* Get all users */
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /* Get user by id */
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /* Get user by id using @RequestParam */
    @GetMapping(value = "/users/byParam", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByParam(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

    /* Update user by id */
    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    /* Patch user by id */
    @PatchMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void patchUser(@PathVariable Integer id, @RequestBody Map<String, String> partialUser) {
        userService.patchUser(id, partialUser);
    }

    /* Delete user by id */
    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    /* Register user by unique username */
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    /* Search by username, first name or last name */
    @GetMapping(value = "/search/{searchedString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUser(@PathVariable String searchedString) {
        return userService.searchUser(searchedString);
    }

    /* Follow */
    @PostMapping(value = "/{username}/follow/{usernameToBeFollowed}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void followUser(@PathVariable String username, @RequestBody User userToBeFollowed) {
        userService.followUser(username, userToBeFollowed.getUsername());
    }

    /* Get user following */
    @GetMapping(value = "/{username}/follows", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getFollowing(@PathVariable String username) {
        return userService.getWhoUserFollows(username);
    }
}
