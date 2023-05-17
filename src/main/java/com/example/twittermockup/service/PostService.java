package com.example.twittermockup.service;

import com.example.twittermockup.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Integer id);
    void registerPost(String username, Post post);
    void updatePost(Integer id, Post post);
    void deletePost(Integer id);
    List<Post> getUserPosts(String username);
    List<Post> getUserPostsByParam(String username, LocalDateTime timestamp);
    List<Post> getUserFeed(String username);
}
