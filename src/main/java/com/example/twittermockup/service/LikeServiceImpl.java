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
        return likeRepository.findAll();
    }

    public Like getLikeById(Integer id) {
        return likeRepository.getReferenceById(id.toString());
    }

    public void registerLike(Like like) {
        likeRepository.save(like);
    }

    public void deleteLike(Integer id) {
        likeRepository.deleteById(id.toString());
    }

    public void addLike(String username, String userPage, Integer postId, Like postLike) {
        List<Like> allLikes = likeRepository.findAll();
        for (Like like : allLikes) {
            if (like.getLikeAuthor().getUsername().equals(username) && like.getLikedPost().getId().equals(postId.toString())) {
                throw new LikeAlreadyExistsException(String.format("Post was already liked by user \"%s\"", username));
            }
        }
        likeRepository.save(postLike);
    }
}
