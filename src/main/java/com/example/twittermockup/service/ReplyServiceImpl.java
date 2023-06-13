package com.example.twittermockup.service;

import com.example.twittermockup.model.Reply;
import com.example.twittermockup.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyRepository.getReferenceById(id.toString());
    }

    @Override
    public void registerReply(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void updateReply(Integer id, Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Integer id) {
        replyRepository.deleteById(id.toString());
    }
}
