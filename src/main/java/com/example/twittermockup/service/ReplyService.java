package com.example.twittermockup.service;

import com.example.twittermockup.model.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getAllReplies();
    Reply getReplyById(Integer id);
    void registerReply(Reply reply);
    void updateReply(Integer id, Reply reply);
    void deleteReply(Integer id);
}
