package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.UserNotFoundException;
import com.example.twittermockup.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, List<Integer>> whoUsersFollow = new HashMap<>();
    private Integer index = 0;

    public List<User> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    public void createUser(User user) {
        user.setUserId(index);
        users.put(index, user);
        whoUsersFollow.put(index, new ArrayList<>());
        index++;
    }

    public void updateUser(Integer id, User user) {
        getUserById(id);
        user.setUserId(id);
        users.put(id, user);
    }

    public void deleteUser(int id) {
        users.remove(id);
    }

    public User getUserById(Integer id) {
        User user = users.get(id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(String.format("User with id %s was not found", id));
        }
        return user;
    }

    public void followUser(Integer idUser, Integer idUserToBeFollowed) {
        if (!whoUsersFollow.get(idUser).contains(idUserToBeFollowed)) {
            whoUsersFollow.get(idUser).add(idUserToBeFollowed);
        }
    }

    public User getUserByUsername(String username) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("User with username \"%s\" doesn't exit", username));
    }

    public List<Integer> getWhoUserFollows(Integer idUser) {
        return whoUsersFollow.get(idUser).stream().toList();
    }

}
