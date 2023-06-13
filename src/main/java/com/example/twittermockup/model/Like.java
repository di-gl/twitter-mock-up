package com.example.twittermockup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User likeAuthor;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post likedPost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getLikeAuthor() {
        return likeAuthor;
    }

    public void setLikeAuthor(User likeAuthor) {
        this.likeAuthor = likeAuthor;
    }

    public Post getLikedPost() {
        return likedPost;
    }

    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + id +
                ", timestamp=" + timestamp +
                ", likeAuthor=" + likeAuthor +
                ", likedPost=" + likedPost +
                '}';
    }
}
