package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.UserNotFoundException;
import com.example.twittermockup.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private Map<Integer, User> users = new HashMap<>();
    private Integer index = 0;

    public List<User> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    public void createUser(User user) {
        user.setUserId(index);
        users.put(index, user);
        index++;
    }

    public User getUserById(Integer id) {
        User user = users.get(id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(String.format("User with id %s was not found", id));
        }
        return user;
    }

    public void updateUser(Integer id, User user) {
        getUserById(id);
        user.setUserId(id);
        users.put(id, user);
    }

    public void deleteUser(int id) {
        users.remove(id);
    }

}
