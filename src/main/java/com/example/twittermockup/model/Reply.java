package com.example.twittermockup.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    @Column(name = "published_date", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDate publishedReplyDate;
    @Column(name = "content", nullable = false)
    private String replyContent;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post repliedPost;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User replyAuthor;
    @Column(name = "is_public", columnDefinition = "boolean default true")
    private boolean isPublic = true;

    public int getReplyId() {
        return id;
    }

    public void setReplyId(int replyId) {
        this.id = replyId;
    }

    public LocalDate getPublishedReplyDate() {
        return publishedReplyDate;
    }

    public void setPublishedReplyDate(LocalDate publishedReplyDate) {
        this.publishedReplyDate = publishedReplyDate;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Post getRepliedPost() {
        return repliedPost;
    }

    public void setRepliedPost(Post repliedPost) {
        this.repliedPost = repliedPost;
    }

    public User getReplyAuthor() {
        return replyAuthor;
    }

    public void setReplyAuthor(User replyAuthor) {
        this.replyAuthor = replyAuthor;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + id +
                ", publishedReplyDate=" + publishedReplyDate +
                ", replyContent='" + replyContent + '\'' +
                ", repliedPost=" + repliedPost +
                ", isPublic=" + isPublic +
                ", replyAuthor=" + replyAuthor +
                '}';
    }
}
