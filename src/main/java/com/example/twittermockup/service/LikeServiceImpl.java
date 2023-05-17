package com.example.twittermockup.service;

import com.example.twittermockup.advice.exception.LikeAlreadyExistsException;
import com.example.twittermockup.model.Like;
import com.example.twittermockup.repository.LikeRepository;
import com.example.twittermockup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
    }

    public List<Like> getAllLikes() {
        return likeRepository.getAllLikes();
    }

    public Like getLikeById(Integer id) {
        return likeRepository.getLikeById(id);
    }

    public void registerLike(Like like) {
        likeRepository.createLike(like);
    }

    public void deleteLike(Integer id) {
        likeRepository.deleteLike(id);
    }

    public void addLike(String username, String userPage, Integer postId, Like postLike) {
        List<Like> allLikes = likeRepository.getAllLikes();
        for (Like like : allLikes) {
            if (like.getLikeAuthor().getUsername().equals(username) && like.getLikedPost().getPostId() == postId) {
                throw new LikeAlreadyExistsException(String.format("Post was already liked by user \"%s\"", username));
            }
        }
        likeRepository.createLike(postLike);
    }
}
