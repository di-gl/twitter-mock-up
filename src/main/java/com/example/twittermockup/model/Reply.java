package com.example.twittermockup.model;

import java.time.LocalDate;

public class Reply {
    private int replyId;
    private LocalDate publishedReplyDate;
    private String replyContent;
    private Post replyPost;
    private boolean isPublic;

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

    public Post getReplyPost() {
        return replyPost;
    }

    public void setReplyPost(Post replyPost) {
        this.replyPost = replyPost;
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
                "replyId=" + replyId +
                ", publishedReplyDate=" + publishedReplyDate +
                ", replyContent='" + replyContent + '\'' +
                ", replyPost=" + replyPost +
                ", isPublic=" + isPublic +
                '}';
    }
}
