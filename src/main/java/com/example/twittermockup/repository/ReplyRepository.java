package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.ReplyNotFoundException;
import com.example.twittermockup.model.Reply;
import com.example.twittermockup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, String> {

}
