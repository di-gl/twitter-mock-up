package com.example.twittermockup.service;

import com.example.twittermockup.model.Like;
import com.example.twittermockup.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public List<Like> getAllLikes() {
        return likeRepository.getAllLikes();
    }

    @Override
    public Like getLikeById(Integer id) {
        return likeRepository.getLikeById(id);
    }

    @Override
    public void registerLike(Like like) {
        likeRepository.createLike(like);
    }

    @Override
    public void updateLike(Integer id, Like like) {
        likeRepository.updateLike(id, like);
    }

    @Override
    public void deleteLike(Integer id) {
        likeRepository.deleteLike(id);
    }
}
