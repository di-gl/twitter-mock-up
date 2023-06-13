package com.example.twittermockup.model;

import java.io.Serializable;

public class FollowId implements Serializable {

    private User user;
    private User followedUser;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    public void setFollowedUser(User followedUser) {
        this.followedUser = followedUser;
    }
}
