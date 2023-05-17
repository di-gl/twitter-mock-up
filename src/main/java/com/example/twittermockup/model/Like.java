package com.example.twittermockup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;

@Component
public class Like {
    private int likeId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private User likeAuthor;
    private Post likedPost;

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getLikeAuthor() {
        return likeAuthor;
    }

    public void setLikeAuthor(User likeAuthor) {
        this.likeAuthor = likeAuthor;
    }

    public Post getLikedPost() {
        return likedPost;
    }

    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", timestamp=" + timestamp +
                ", likeAuthor=" + likeAuthor +
                ", likedPost=" + likedPost +
                '}';
    }
}
