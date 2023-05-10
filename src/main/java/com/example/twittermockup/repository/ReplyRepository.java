package com.example.twittermockup.repository;

import com.example.twittermockup.advice.exception.ReplyNotFoundException;
import com.example.twittermockup.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ReplyRepository {
    private Map<Integer, Reply> replies = new HashMap<>();
    private Integer index = 0;

    public List<Reply> getAllReplies() {
        return replies.values().stream().collect(Collectors.toList());
    }

    public void createReply(Reply reply) {
        reply.setReplyId(index);
        replies.put(index, reply);
        index++;
    }

    public void updateReply(Integer id, Reply reply) {
        getReplyById(id);
        reply.setReplyId(id);
        replies.put(id, reply);
    }

    public void deleteReply(int id) {
        replies.remove(id);
    }

    public Reply getReplyById(Integer id) {
        Reply reply = replies.get(id);
        if (Objects.isNull(reply)) {
            throw new ReplyNotFoundException(String.format("Reply with id %s was not found", id));
        }
        return reply;
    }
}
