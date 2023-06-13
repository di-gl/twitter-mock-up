package com.example.twittermockup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
@Getter
@Setter
@ToString
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
}
