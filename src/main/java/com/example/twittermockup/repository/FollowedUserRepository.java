package com.example.twittermockup.repository;

import com.example.twittermockup.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowedUserRepository extends JpaRepository<Follow, String> {
    List<Follow> findByUserId(String id);

}
