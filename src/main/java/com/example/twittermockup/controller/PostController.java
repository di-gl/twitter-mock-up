package com.example.twittermockup.controller;

import com.example.twittermockup.model.Post;
import com.example.twittermockup.model.User;
import com.example.twittermockup.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    /* Get all posts */
    @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    /* Get own posts without timestamp */
    @GetMapping(value = "/{username}/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getUserPosts(@PathVariable String username) {
        return postService.getUserPosts(username);
    }

    /* Get own posts using timestamp */
    @GetMapping(value = "/{username}/posts", params = "timestamp", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getUserPostsByParam(@PathVariable String username, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime timestamp) {
        return postService.getUserPostsByParam(username, timestamp);
    }

    /* Get feed */
    @GetMapping(value = "/{username}/feed", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getUserFeed(@PathVariable String username) {
        return postService.getUserFeed(username);
    }

    /* Get post by id */
    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    /* Add post */
    @PostMapping(value = "/{username}/addPost", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerPost(@PathVariable String username, @RequestBody Post post) {
        postService.registerPost(username, post);
    }

    /* Update post */
    @PutMapping(value = "/posts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePost(@PathVariable Integer id, @RequestBody Post post) {
        postService.updatePost(id, post);
    }

    /* Delete post by id */
    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }
}
