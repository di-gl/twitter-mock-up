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

    @Override
    public List<Post> getAllPost() {
        return postRepository.getAllPosts();
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.getPostById(id);
    }

    @Override
    public void registerPost(Post post) {
        postRepository.createPost(post);
    }

    @Override
    public void updatePost(Integer id, Post post) {
        postRepository.updatePost(id, post);
    }

    @Override
    public void delete(Integer id) {
        postRepository.deletePost(id);
    }
}
