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

    List<User> searchUser(String searchedString);

    void isRegistered(User user);

    void followUser(String username, String usernameToBeFollowed);

    List<String> getWhoUserFollows(String username);
}
