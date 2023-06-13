package com.example.twittermockup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "published_date", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime publishedDate;
    @Column(name = "content", nullable = false)
    private String postContent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User postAuthor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public User getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(User postAuthor) {
        this.postAuthor = postAuthor;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + id +
                ", publishedDate=" + publishedDate +
                ", postContent='" + postContent + '\'' +
                ", postAuthor=" + postAuthor +
                '}';
    }
}
