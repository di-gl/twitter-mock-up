package com.example.twittermockup.model;

import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Like {
    private int likeId;
    private Calendar timestamp;
    private User likeAuthor;
    private Post likedPost;

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
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
