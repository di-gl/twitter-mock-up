package com.example.twittermockup.service;

import com.example.twittermockup.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Integer id);

    void registerUser(User user);

    void updateUser(Integer id, User user);

    void patchUser(Integer id, Map<String, String> partialUser);

    void deleteUser(Integer id);
    User searchUser(String searchedString);
    void registerUser(String username, String firstName, String lastName, String email, String password);

}
