package com.example.twittermockup.advice.exception;

public class ReplyNotFoundException extends RuntimeException {

    public ReplyNotFoundException(String message) {
        super(message);
    }
}
