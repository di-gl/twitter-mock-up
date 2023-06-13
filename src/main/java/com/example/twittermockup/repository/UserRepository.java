package com.example.twittermockup.repository;

import com.example.twittermockup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

}
