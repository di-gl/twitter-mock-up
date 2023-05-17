package com.example.twittermockup.controller;

import com.example.twittermockup.model.Like;
import com.example.twittermockup.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    @Autowired
    private LikeService likeService;

    /* Like a post */
    @PostMapping(value = "{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLike(@PathVariable String username, @RequestParam("userPage") String userPage, @RequestParam("postId") Integer postId, @RequestBody Like like) {
        likeService.addLike(username, userPage, postId, like);
    }

    @GetMapping(value = "/likes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }

}
