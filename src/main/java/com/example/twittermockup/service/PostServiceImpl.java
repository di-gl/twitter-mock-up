package com.example.twittermockup.service;

import com.example.twittermockup.model.Post;
import com.example.twittermockup.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public Post getPostById(Integer id) {
        return postRepository.getPostById(id);
    }

    public void registerPost(Post post) {
        postRepository.createPost(post);
    }

    public void updatePost(Integer id, Post post) {
        postRepository.updatePost(id, post);
    }

    public void deletePost(Integer id) {
        postRepository.deletePost(id);
    }
}
