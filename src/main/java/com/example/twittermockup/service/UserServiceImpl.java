package com.example.twittermockup.service;

import com.example.twittermockup.advice.exception.UserAlreadyExistsException;
import com.example.twittermockup.advice.exception.UserNotFoundException;
import com.example.twittermockup.model.User;
import com.example.twittermockup.repository.UserRepository;
import com.example.twittermockup.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserUtil userUtil) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void registerUser(User registeringUser) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(registeringUser.getUsername())) {
                throw new UserAlreadyExistsException(String.format("User with username \"%s\" is already registered", registeringUser.getUsername()));
            }
        }
        userRepository.createUser(registeringUser);
    }

    public void updateUser(Integer id, User user) {
        userRepository.updateUser(id, user);
    }

    public void patchUser(Integer id, Map<String, String> partialUser) {
        User user = userRepository.getUserById(id);
        userUtil.patchUser(user, partialUser);
        userRepository.updateUser(id, user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }

    @Override
    public List<User> searchUser(String searchedString) {
        List<User> users = getAllUsers();
        List<User> usersMatched = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().equals(searchedString) || user.getFirstName().equals(searchedString) || user.getLastName().equals(searchedString)) {
                usersMatched.add(user);
            }
        }
        if (usersMatched.isEmpty()) {
            throw new UserNotFoundException(String.format("User with \"%s\" as username, first name or last name was not found", searchedString));
        }
        return usersMatched;
    }

    public void isRegistered(User user) {
        List<User> users = getAllUsers();
        if (!users.contains(user)) {
            throw new UserAlreadyExistsException(String.format("User with username \"%s\" was registered", user.getUsername()));
        }
    }

    public void followUser(String username, String usernameToBeFollowed) {
        userRepository.followUser(userRepository.getUserByUsername(username).getUserId(), userRepository.getUserByUsername(usernameToBeFollowed).getUserId());
    }

    public List<String> getWhoUserFollows(String username) {
        List<Integer> usersFollowed = userRepository.getWhoUserFollows(userRepository.getUserByUsername(username).getUserId());
        List<String> getUsersFollowedByUsername = new ArrayList<>();
        usersFollowed.forEach(u -> {
            getUsersFollowedByUsername.add(getUserById(u).getUsername());
        });
        return getUsersFollowedByUsername;
    }
}