package com.example.twittermockup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
@ToString
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
}
