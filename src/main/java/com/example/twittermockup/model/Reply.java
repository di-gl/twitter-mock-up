package com.example.twittermockup.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "replies")
@Getter
@Setter
@ToString
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "published_date", columnDefinition = "DATE", nullable = false)
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
    private boolean isPublic;
}
