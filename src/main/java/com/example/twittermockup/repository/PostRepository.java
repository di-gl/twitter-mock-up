package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.PostNotFoundException;
import com.example.twittermockup.model.Post;
import com.example.twittermockup.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

}
