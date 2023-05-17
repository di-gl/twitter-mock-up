package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.PostNotFoundException;
import com.example.twittermockup.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private Map<Integer, Post> posts = new HashMap<>();
    private Integer index = 0;

    public List<Post> getAllPosts() {
        return posts.values().stream().collect(Collectors.toList());
    }

    public void createPost(String username, Post post) {
        if (!post.getPostAuthor().getUsername().equals(username)) {
            throw new PostNotFoundException(String.format("Post cannot be created by anyone else but \"%s\"", username));
        }
        post.setPostId(index);
        posts.put(index, post);
        index++;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public void updatePost(Integer id, Post post) {
        getPostById(id);
        post.setPostId(id);
        posts.put(id, post);
    }

    public void deletePost(int id) {
        posts.remove(id);
    }

    public Post getPostById(Integer id) {
        Post post = posts.get(id);
        if (Objects.isNull(post)) {
            throw new PostNotFoundException(String.format("Post with id %s was not found", id));
        }
        return post;
    }
}
