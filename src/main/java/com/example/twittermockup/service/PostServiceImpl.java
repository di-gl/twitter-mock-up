package com.example.twittermockup.service;

import com.example.twittermockup.advice.exception.PostNotFoundException;
import com.example.twittermockup.model.Post;
import com.example.twittermockup.model.User;
import com.example.twittermockup.repository.PostRepository;
import com.example.twittermockup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer id) {
        return postRepository.getReferenceById(id.toString());
    }

    public void registerPost(String username, Post post) {
        postRepository.save(post);
    }

    public void updatePost(Integer id, Post post) {
        postRepository.save(post);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id.toString());
    }

    public List<Post> getUserPosts(String username) {
        List<Post> allPosts = postRepository.findAll();
        List<Post> userPosts = new ArrayList<>();
        for (Post post : allPosts) {
            if (post.getPostAuthor().getUsername().equals(username)) {
                userPosts.add(post);
            }
        }
        if (userPosts.isEmpty()) {
            throw new PostNotFoundException(String.format("User \"%s\" has made no posts up until now", username));
        }
        return userPosts;
    }

    public List<Post> getUserPostsByParam(String username, LocalDateTime timestamp) {
        List<Post> userPosts = getUserPosts(username);
        List<Post> userPostsFilteredByTimestamp = new ArrayList<>();
        for (Post post : userPosts) {
            if (post.getPublishedDate().isBefore(timestamp)) {
                userPostsFilteredByTimestamp.add(post);
            }
        }
        if (userPostsFilteredByTimestamp.isEmpty()) {
            throw new PostNotFoundException(String.format("User \"%s\" has made no posts before the timestamp %s", username, timestamp.toString()));
        }
        return userPostsFilteredByTimestamp;
    }

    /*

    public List<Post> getUserFeed(String username) {
        User user = userRepository.findByUsername(username);
        List<Integer> whoUserFollows = userRepository.getWhoUserFollows(user.getUserId());
        List<Post> allPosts = postRepository.getAllPosts();
        List<Post> feedPosts = new ArrayList<>();
        for (Integer userId : whoUserFollows) {
            for (Post post : allPosts) {
                if (post.getPostAuthor().getUsername().equals(userRepository.getReferenceById(userId.toString()).getUsername())) {
                    feedPosts.add(post);
                }
            }
        }
        return feedPosts;
    }

     */
}
