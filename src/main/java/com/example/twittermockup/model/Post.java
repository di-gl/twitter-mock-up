package com.example.twittermockup.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Post {
    private int postId;
    private LocalDate publishedDate;
    private String postContent;
    private int numberOfLikes;
    private ArrayList<Reply> postReplies;

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

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public ArrayList<Reply> getPostReplies() {
        return postReplies;
    }

    public void setPostReplies(ArrayList<Reply> postReplies) {
        this.postReplies = postReplies;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", publishedDate=" + publishedDate +
                ", postContent='" + postContent + '\'' +
                ", numberOfLikes=" + numberOfLikes +
                ", postReplies=" + postReplies +
                '}';
    }
}
