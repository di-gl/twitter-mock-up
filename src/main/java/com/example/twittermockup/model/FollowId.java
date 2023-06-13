package com.example.twittermockup.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FollowId implements Serializable {

    private User user;
    private User followedUser;
}
