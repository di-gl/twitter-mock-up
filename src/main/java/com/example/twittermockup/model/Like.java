package com.example.twittermockup.model;

public class Like {
    private int numberOfLikes;
    private Post post;

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Like{" +
                "numberOfLikes=" + numberOfLikes +
                ", post=" + post +
                '}';
    }
}
