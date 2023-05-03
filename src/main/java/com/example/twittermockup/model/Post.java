package com.example.twittermockup.model;

import java.time.LocalDate;
import java.util.Map;

public class Post {
    private int postId;
    private LocalDate publishedDate;
    private String postContent;
    private User postCreator;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public User getPostCreator() {
        return postCreator;
    }

    public void setPostCreator(User postCreator) {
        this.postCreator = postCreator;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", publishedDate=" + publishedDate +
                ", postContent='" + postContent + '\'' +
                ", postCreator=" + postCreator +
                '}';
    }
}
