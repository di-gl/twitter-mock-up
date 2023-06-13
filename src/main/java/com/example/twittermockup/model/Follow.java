package com.example.twittermockup.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "followed_users")
@IdClass(FollowId.class)
@Getter
@Setter
public class Follow {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "followed_user_id", nullable = false)
    private User followedUser;
}
