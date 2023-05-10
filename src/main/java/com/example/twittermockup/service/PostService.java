package com.example.twittermockup.service;

import com.example.twittermockup.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Integer id);
    void registerPost(Post post);
    void updatePost(Integer id, Post post);
    void deletePost(Integer id);
}
