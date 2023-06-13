package com.example.twittermockup.service;

import com.example.twittermockup.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(String id);

    void registerUser(User user);

    void updateUser(User user);

    void patchUser(String id, Map<String, String> partialUser);

    void deleteUser(String id);

    List<User> searchUser(String searchedString);

    void isRegistered(User user);

    void followUser(String username, User userToBeFollowed);

    List<String> getWhoUserFollows(String username);
}
