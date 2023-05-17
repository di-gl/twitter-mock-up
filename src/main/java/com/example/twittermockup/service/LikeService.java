package com.example.twittermockup.service;

import com.example.twittermockup.model.Like;

import java.util.List;

public interface LikeService {
    List<Like> getAllLikes();
    Like getLikeById(Integer id);
    void registerLike(Like like);
    void deleteLike(Integer id);
    void addLike(String username, String userPage, Integer postId, Like like);
}
