package com.example.twittermockup.model;

import jakarta.persistence.*;

@Entity
@Table(name = "followed_users")
@IdClass(FollowId.class)
public class Follow {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "followed_user_id", nullable = false)
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
