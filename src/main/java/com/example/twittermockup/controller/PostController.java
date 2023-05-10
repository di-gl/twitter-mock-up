package com.example.twittermockup.controller;

import com.example.twittermockup.model.Post;
import com.example.twittermockup.model.User;
import com.example.twittermockup.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @GetMapping(value = "/posts/byParam", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post getPostByParam(@RequestParam Integer id) {
        return postService.getPostById(id);
    }

    @PostMapping(value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerPost(@RequestBody Post post) {
        postService.registerPost(post);
    }

    @PutMapping(value = "/posts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePost(@PathVariable Integer id, @RequestBody Post post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }
}
