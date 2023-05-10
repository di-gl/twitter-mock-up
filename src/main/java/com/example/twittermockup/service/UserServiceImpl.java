package com.example.twittermockup.service;

import com.example.twittermockup.advice.exception.UserAlreadyExistsException;
import com.example.twittermockup.advice.exception.UserNotFoundException;
import com.example.twittermockup.model.User;
import com.example.twittermockup.repository.UserRepository;
import com.example.twittermockup.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void registerUser(User user) {
        userRepository.createUser(user);
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
    public User searchUser(String searchedString) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(searchedString) || user.getFirstName().equals(searchedString) || user.getLastName().equals(searchedString)) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("User with \"%s\" as username, first name or last name was not found", searchedString));
    }

    @Override
    public void registerUser(String username, String firstName, String lastName, String email, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                throw new UserAlreadyExistsException(String.format("User with username \"%s\" is already registered", username));
            }
        }
        User registeringUser = new User();
        registeringUser.setUsername(username);
        registeringUser.setFirstName(firstName);
        registeringUser.setLastName(lastName);
        registeringUser.setEmail(email);
        registeringUser.setPassword(password);
        registerUser(registeringUser);
    }
}