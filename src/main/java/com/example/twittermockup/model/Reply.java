package com.example.twittermockup.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Reply {
    private int replyId;
    private LocalDate publishedReplyDate;
    private String replyContent;
    private Post repliedPost;
    private boolean isPublic;
    private User replyAuthor;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public User getReplyAuthor() {
        return replyAuthor;
    }

    public void setReplyAuthor(User replyAuthor) {
        this.replyAuthor = replyAuthor;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", publishedReplyDate=" + publishedReplyDate +
                ", replyContent='" + replyContent + '\'' +
                ", repliedPost=" + repliedPost +
                ", isPublic=" + isPublic +
                ", replyAuthor=" + replyAuthor +
                '}';
    }
}
