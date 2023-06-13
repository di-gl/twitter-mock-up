package com.example.twittermockup.service;

import com.example.twittermockup.advice.exception.UserAlreadyExistsException;
import com.example.twittermockup.advice.exception.UserNotFoundException;
import com.example.twittermockup.model.Follow;
import com.example.twittermockup.model.User;
import com.example.twittermockup.repository.FollowedUserRepository;
import com.example.twittermockup.repository.UserRepository;
import com.example.twittermockup.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;
    private final FollowedUserRepository followedUserRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserUtil userUtil, FollowedUserRepository followedUserRepository) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
        this.followedUserRepository = followedUserRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        if (userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException(String.format("User with \"%s\" id was not found", id));
        }
        return userRepository.findById(id).get();
    }

    @Override
    public void registerUser(User registeringUser) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(registeringUser.getUsername())) {
                throw new UserAlreadyExistsException(String.format("User with username \"%s\" is already registered", registeringUser.getUsername()));
            }
        }
        userRepository.save(registeringUser);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void patchUser(String id, Map<String, String> partialUser) {
        User user = userRepository.getReferenceById(id);
        userUtil.patchUser(user, partialUser);
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
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

    public void followUser(String username, User userToBeFollowed) {
        Follow follow = new Follow();
        follow.setUser(userRepository.findByUsername(username));
        follow.setFollowedUser(userToBeFollowed);
        followedUserRepository.save(follow);
    }

    public List<String> getWhoUserFollows(String username) {
        List<Follow> usersFollowed = followedUserRepository.findByUserId(userRepository.findByUsername(username).getId());
        List<String> getUsersFollowedByUsername = new ArrayList<>();
        usersFollowed.forEach(u -> {
            getUsersFollowedByUsername.add(u.getFollowedUser().getUsername());
        });
        return getUsersFollowedByUsername;
    }

}