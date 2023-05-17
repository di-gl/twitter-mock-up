package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.LikeNotFoundException;
import com.example.twittermockup.model.Like;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class LikeRepository {
    private Map<Integer, Like> likes = new HashMap<>();
    Integer index = 0;

    public List<Like> getAllLikes() {
        return likes.values().stream().collect(Collectors.toList());
    }

    public void createLike(Like like) {
        like.setLikeId(index);
        likes.put(index, like);
        index++;
    }

    public void deleteLike(Integer id) {
        likes.remove(id);
    }

    public Like getLikeById(Integer id) {
        Like like = likes.get(id);
        if (Objects.isNull(like)) {
            throw new LikeNotFoundException(String.format("Like with id %s was not found", id));
        }
        return like;
    }
}
